/*
 * Copyright (c) MuleSoft, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.raml.parser.visitor;

import static org.raml.parser.rule.ValidationMessage.NON_SCALAR_KEY_MESSAGE;
import static org.raml.parser.rule.ValidationResult.createErrorResult;
import static org.raml.parser.tagresolver.IncludeResolver.INCLUDE_APPLIED_TAG;
import static org.raml.parser.tagresolver.IncludeResolver.INCLUDE_TAG;
import static org.raml.parser.visitor.TupleType.KEY;
import static org.raml.parser.visitor.TupleType.VALUE;
import static org.yaml.snakeyaml.nodes.NodeId.scalar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

import org.raml.parser.rule.DefaultTupleRule;
import org.raml.parser.rule.NodeRule;
import org.raml.parser.rule.NodeRuleFactory;
import org.raml.parser.rule.SequenceRule;
import org.raml.parser.rule.TupleRule;
import org.raml.parser.rule.ValidationResult;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

/**
 * <p>YamlDocumentValidator class.</p>
 *
 * @author kor
 * @version $Id: $Id
 */
public class YamlDocumentValidator implements YamlValidator {

    private Class<?> documentClass;
    private Stack<NodeRule<?>> ruleContext = new Stack<NodeRule<?>>();
    private Deque<IncludeInfo> includeContext = new ArrayDeque<IncludeInfo>();
    private List<ValidationResult> messages = new ArrayList<ValidationResult>();
    private NodeRuleFactory nodeRuleFactory;


    /**
     * <p>Constructor for YamlDocumentValidator.</p>
     *
     * @param documentClass a {@link java.lang.Class} object.
     */
    protected YamlDocumentValidator(Class<?> documentClass) {
        this(documentClass, new NodeRuleFactory());
    }

    /**
     * <p>Constructor for YamlDocumentValidator.</p>
     *
     * @param documentClass   a {@link java.lang.Class} object.
     * @param nodeRuleFactory a {@link org.raml.parser.rule.NodeRuleFactory} object.
     */
    protected YamlDocumentValidator(Class<?> documentClass, NodeRuleFactory nodeRuleFactory) {
        this.documentClass = documentClass;
        this.nodeRuleFactory = nodeRuleFactory;
    }

    /**
     * <p>Getter for the field <code>ruleContext</code>.</p>
     *
     * @return a {@link java.util.Stack} object.
     */
    protected Stack<NodeRule<?>> getRuleContext() {
        return ruleContext;
    }


    /**
     * {@inheritDoc}
     */
    public void onMappingNodeStart(MappingNode node, TupleType tupleType) {
        if (tupleType == KEY) {
            addMessage(createErrorResult(NON_SCALAR_KEY_MESSAGE, node));
        }
    }


    /**
     * {@inheritDoc}
     */
    public void onMappingNodeEnd(MappingNode node, TupleType tupleType) {
    }


    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public void onSequenceStart(SequenceNode node, TupleType tupleType) {
        if (tupleType == KEY) {
            addMessage(createErrorResult(NON_SCALAR_KEY_MESSAGE, node));
        } else {
            NodeRule<SequenceNode> peek = (NodeRule<SequenceNode>) ruleContext.peek();
            addMessages(peek.validateValue(node));
        }
    }


    /**
     * {@inheritDoc}
     */
    public void onSequenceEnd(SequenceNode node, TupleType tupleType) {

    }


    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public void onScalar(ScalarNode node, TupleType tupleType) {
        List<ValidationResult> result;
        NodeRule<?> peek = ruleContext.peek();

        if (tupleType == VALUE) {
            result = ((NodeRule<ScalarNode>) peek).validateValue(node);
        } else {
            result = ((TupleRule<ScalarNode, ?>) peek).validateKey(node);
        }
        addMessages(result);
    }

    private void addMessages(List<ValidationResult> result) {
        for (ValidationResult validationResult : result) {
            validationResult.addIncludeContext(includeContext);
            messages.add(validationResult);
        }
    }

    private void addMessage(ValidationResult errorResult) {
        addMessages(Collections.<ValidationResult>singletonList(errorResult));
    }


    /**
     * {@inheritDoc}
     */
    public void onDocumentStart(MappingNode node) {
        ruleContext.push(buildDocumentRule());
    }


    /**
     * {@inheritDoc}
     */
    public void onDocumentEnd(MappingNode node) {
        NodeRule<?> pop = ruleContext.pop();

        List<ValidationResult> onRuleEnd = pop.onRuleEnd();
        addMessages(onRuleEnd);

    }


    /**
     * {@inheritDoc}
     */
    public void onTupleEnd(NodeTuple nodeTuple) {
        NodeRule<?> rule = ruleContext.pop();
        if (rule != null) {
            List<ValidationResult> onRuleEnd = rule.onRuleEnd();
            addMessages(onRuleEnd);
        } else {
            throw new IllegalStateException("Unexpected ruleContext state");
        }
    }


    /**
     * {@inheritDoc}
     */
    public void onTupleStart(NodeTuple nodeTuple) {

        TupleRule<?, ?> tupleRule = (TupleRule<?, ?>) ruleContext.peek();
        if (tupleRule != null) {
            TupleRule<?, ?> rule = tupleRule.getRuleForTuple(nodeTuple);
            ruleContext.push(rule);
        } else {
            throw new IllegalStateException("Unexpected ruleContext state");
        }

    }


    /**
     * {@inheritDoc}
     */
    public void onSequenceElementStart(Node sequenceNode) {
        NodeRule peek = ruleContext.peek();
        if (!(peek instanceof SequenceRule)) {
            ruleContext.push(peek);
        } else {
            ruleContext.push(((SequenceRule) peek).getItemRule());
        }
    }


    /**
     * {@inheritDoc}
     */
    public void onSequenceElementEnd(Node sequenceNode) {
        NodeRule<?> rule = ruleContext.pop();
        List<ValidationResult> validationResults = rule.onRuleEnd();
        addMessages(validationResults);
    }


    /**
     * {@inheritDoc}
     */
    public void onCustomTagStart(Tag tag, Node originalValueNode, Node node) {
        if (INCLUDE_TAG.equals(tag) && originalValueNode.getNodeId() == scalar) {
            includeContext.push(new IncludeInfo((ScalarNode) originalValueNode));
        } else if (tag.startsWith(INCLUDE_APPLIED_TAG)) {
            includeContext.push(new IncludeInfo(tag));
        }
    }


    /**
     * {@inheritDoc}
     */
    public void onCustomTagEnd(Tag tag, Node originalValueNode, Node node) {
        if ((INCLUDE_TAG.equals(tag) && originalValueNode.getNodeId() == scalar) ||
                tag.startsWith(INCLUDE_APPLIED_TAG)) {
            includeContext.pop();
        }
    }


    /**
     * {@inheritDoc}
     */
    public void onCustomTagError(Tag tag, Node node, String message) {
        addMessages(Arrays.asList(createErrorResult(message, node.getStartMark(), node.getEndMark())));
    }


    private DefaultTupleRule<Node, MappingNode> buildDocumentRule() {

        return nodeRuleFactory.createDocumentRule(documentClass);
    }


    /**
     * <p>Getter for the field <code>messages</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<ValidationResult> getMessages() {
        return messages;
    }
}
