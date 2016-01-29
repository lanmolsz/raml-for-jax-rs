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
package org.raml.parser.rule;

import java.lang.reflect.Type;
import java.util.List;

import org.raml.parser.resolver.DefaultScalarTupleHandler;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;

/**
 * <p>PojoTupleRule class.</p>
 *
 * @author kor
 * @version $Id: $Id
 */
public class PojoTupleRule extends DefaultTupleRule<ScalarNode, MappingNode> {

    private Class<?> pojoClass;

    /**
     * <p>Constructor for PojoTupleRule.</p>
     *
     * @param fieldName       a {@link java.lang.String} object.
     * @param pojoClass       a {@link java.lang.Class} object.
     * @param nodeRuleFactory a {@link org.raml.parser.rule.NodeRuleFactory} object.
     */
    public PojoTupleRule(String fieldName, Class<?> pojoClass, NodeRuleFactory nodeRuleFactory) {
        this(fieldName, pojoClass);
        setNodeRuleFactory(nodeRuleFactory);
    }

    /**
     * <p>Constructor for PojoTupleRule.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @param pojoClass a {@link java.lang.Class} object.
     */
    public PojoTupleRule(String fieldName, Class<?> pojoClass) {
        super(fieldName, new DefaultScalarTupleHandler(fieldName));
        this.pojoClass = pojoClass;
    }


    /**
     * {@inheritDoc}
     */
    public TupleRule<?, ?> getRuleForTuple(NodeTuple nodeTuple) {
        if (rules.isEmpty()) {
            addRulesFor(pojoClass);
        }
        return super.getRuleForTuple(nodeTuple);
    }


    /**
     * <p>getValueNodeType.</p>
     *
     * @return an array of {@link java.lang.Class} objects.
     */
    public Class<?>[] getValueNodeType() {
        return new Class[]{MappingNode.class};
    }


    /**
     * {@inheritDoc}
     */
    public void setValueType(Type valueType) {
        pojoClass = (Class<?>) valueType;
    }


    /**
     * <p>validateKey.</p>
     *
     * @param key a {@link org.yaml.snakeyaml.nodes.ScalarNode} object.
     * @return a {@link java.util.List} object.
     */
    public List<ValidationResult> validateKey(ScalarNode key) {
        List<ValidationResult> validationResults = super.validateKey(key);
        if (getParentTupleRule() instanceof MapTupleRule) {
            ((MapTupleRule) getParentTupleRule()).checkDuplicate(key, validationResults);
        }
        return validationResults;
    }
}
