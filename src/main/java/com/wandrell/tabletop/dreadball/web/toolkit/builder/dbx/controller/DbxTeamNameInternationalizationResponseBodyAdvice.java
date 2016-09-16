
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

@ControllerAdvice(basePackageClasses = { DbxTeamBuilderRestController.class })
public final class DbxTeamNameInternationalizationResponseBodyAdvice
        implements ResponseBodyAdvice<SponsorTeam> {

    /**
     * Message source.
     */
    @Autowired
    private MessageSource messageSource;

    public DbxTeamNameInternationalizationResponseBodyAdvice() {
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
