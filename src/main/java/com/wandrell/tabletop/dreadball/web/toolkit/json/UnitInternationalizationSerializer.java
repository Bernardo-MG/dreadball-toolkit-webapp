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

import java.io.IOException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;

/**
 * Internationalizes data during JSON serialization.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class UnitInternationalizationSerializer
        extends BeanSerializerBase {

    private static final Logger LOGGER           = LoggerFactory
            .getLogger(UnitInternationalizationSerializer.class);

    /**
     * Serialization id.
     */
    private static final long   serialVersionUID = -4564768381234004926L;

    /**
     * The message source used for internationalization.
     */
    private final MessageSource messageSource;

    /**
     * Constructs a serializer with the specified parameters.
     * 
     * @param source
     *            serializer base
     * @param ms
     *            message source
     */
    public UnitInternationalizationSerializer(final BeanSerializerBase source,
            final MessageSource ms) {
        super(source);

        messageSource = checkNotNull(ms,
                "Received a null pointer as message source");
    }

    @Override
    public final void serialize(final Object value, final JsonGenerator gen,
            final SerializerProvider provider) throws IOException {
        String localized;

        gen.writeStartObject();
        serializeFields(value, gen, provider);
        if (value instanceof Unit) {
            try {
                localized = getMessageSource().getMessage(
                        String.valueOf(((Unit) value).getRole()).toLowerCase(),
                        null, LocaleContextHolder.getLocale());

                gen.writeStringField("role_i18n", localized);
            } catch (final NoSuchMessageException e) {
                LOGGER.error("Error localizing message", e);
            }

            try {
                localized = getMessageSource().getMessage(
                        ((Unit) value).getTemplateName(), null,
                        LocaleContextHolder.getLocale());

                gen.writeStringField("template_name_i18n", localized);
            } catch (final NoSuchMessageException e) {
                LOGGER.error("Error localizing message", e);
            }
        }
        if (value instanceof Ability) {
            try {
                localized = getMessageSource().getMessage(
                        ((Ability) value).getName(), null,
                        LocaleContextHolder.getLocale());

                gen.writeStringField("name_i18n", localized);
            } catch (final NoSuchMessageException e) {
                LOGGER.error("Error localizing message", e);
            }

            try {
                localized = getMessageSource().getMessage(
                        ((Ability) value).getName() + ".description", null,
                        LocaleContextHolder.getLocale());

                gen.writeStringField("description_i18n", localized);
            } catch (final NoSuchMessageException e) {
                LOGGER.error("Error localizing message", e);
            }
        }
        gen.writeEndObject();
    }

    @Override
    public final BeanSerializerBase withFilterId(final Object filterId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final BeanSerializerBase
            withObjectIdWriter(final ObjectIdWriter objectIdWriter) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Returns the message source.
     * 
     * @return the message source
     */
    private final MessageSource getMessageSource() {
        return messageSource;
    }

    @Override
    protected final BeanSerializerBase asArraySerializer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected final BeanSerializerBase
            withIgnorals(final Set<String> toIgnore) {
        // TODO Auto-generated method stub
        return null;
    }

}
