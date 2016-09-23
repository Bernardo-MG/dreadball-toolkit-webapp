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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.DefaultUnit;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Controller advice which intercepts the {@code SponsorTeam} when a new unit
 * was added and internationalizes its name.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ControllerAdvice(basePackageClasses = { DbxTeamBuilderRestController.class })
public final class DbxNewUnitNameInternationalizator
        implements ResponseBodyAdvice<SponsorTeam> {

    /**
     * Message source.
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * Default constructor.
     */
    public DbxNewUnitNameInternationalizator() {
        super();
    }

    @Override
    public final SponsorTeam beforeBodyWrite(final SponsorTeam body,
            final MethodParameter returnType,
            final MediaType selectedContentType,
            final Class<? extends HttpMessageConverter<?>> selectedConverterType,
            final ServerHttpRequest request,
            final ServerHttpResponse response) {
        String name;            // Unit name

        for (final Unit unit : body.getPlayers().values()) {
            try {
                name = getMessageSource().getMessage(unit.getName(), null,
                        LocaleContextHolder.getLocale());

                ((DefaultUnit) unit).setName(name);
            } catch (final NoSuchMessageException e) {}
        }
        return body;
    }

    @Override
    public final boolean supports(final MethodParameter returnType,
            final Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
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
