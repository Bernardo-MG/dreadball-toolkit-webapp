/**
 * Copyright 2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.dreadball.web.toolkit.json;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.context.MessageSource;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;

/**
 * Prepares a bean serielizer to internationalize data during JSON
 * serialization.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class InternationalizationBeanSerializerModifier
        extends BeanSerializerModifier {

    /**
     * Message source.
     */
    private final MessageSource messageSource;

    /**
     * Creates a modifier with the specified arguments.
     * 
     * @param ms
     *            message source to use
     */
    public InternationalizationBeanSerializerModifier(final MessageSource ms) {
        super();

        messageSource = checkNotNull(ms,
                "Received a null pointer as message source");
    }

    @Override
    public final JsonSerializer<?> modifySerializer(
            final SerializationConfig config, final BeanDescription beanDesc,
            final JsonSerializer<?> serializer) {
        final JsonSerializer<?> result;

        if (serializer instanceof BeanSerializerBase) {
            result = new UnitInternationalizationSerializer(
                    (BeanSerializerBase) serializer, getMessageSource());
        } else {
            result = serializer;
        }

        return result;
    }

    /**
     * Returns the message source.
     * 
     * @return the message source
     */
    private final MessageSource getMessageSource() {
        return messageSource;
    }

}
