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
package org.raml.model.validation;

/**
 * <p>MaximumIntegerValidation class.</p>
 *
 * @author kor
 * @version $Id: $Id
 */
public class MaximumIntegerValidation implements Validation {

    private Integer maximum;

    /**
     * <p>Constructor for MaximumIntegerValidation.</p>
     *
     * @param maximum a {@link java.lang.String} object.
     */
    public MaximumIntegerValidation(String maximum) {
        this.maximum = parse(maximum);
    }

    /**
     * <p>parse.</p>
     *
     * @param value a {@link java.lang.String} object.
     * @return a {@link java.lang.Integer} object.
     */
    public Integer parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cannot parse number: " + value);
        }
    }


    /**
     * {@inheritDoc}
     */
    public boolean check(String input) {
        return maximum.compareTo(parse(input)) >= 0;
    }
}
