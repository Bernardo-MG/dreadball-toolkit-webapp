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

package com.bernardomg.tabletop.dreadball.web.error;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bernardomg.tabletop.dreadball.web.error.bean.DefaultErrorResponse;
import com.bernardomg.tabletop.dreadball.web.error.bean.ErrorResponse;

/**
 * Initializes all the controllers with a common configuration.
 * <p>
 * TODO: Check http://www.baeldung.com/exception-handling-for-rest-with-spring
 * <p>
 * TODO: Tests
 * http://stackoverflow.com/questions/16669356/testing-spring-mvc-exceptionhandler-method-with-spring-mvc-test
 * <p>
 * TODO:
 * http://www.asyncdev.net/2011/12/spring-restful-controllers-and-error-handling/
 * <p>
 * TODO:
 * http://www.concretepage.com/spring-4/spring-4-mvc-rest-web-service-exception-handling-with-restcontroller-example
 * <p>
 * TODO:
 * https://blog.jayway.com/2013/02/03/improve-your-spring-rest-api-part-iii/
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ControllerAdvice
public final class ControllerExceptionHandler {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ControllerExceptionHandler.class);

    /**
     * Message source.
     */
    private final MessageSource messageSource;

    /**
     * Constructs an exception handler.
     * 
     * @param messageSource
     *            the message source
     */
    public ControllerExceptionHandler(final MessageSource messageSource) {
        super();

        this.messageSource = checkNotNull(messageSource,
                "Received a null pointer as message source");
    }

    /**
     * Processes an illegal argument exception.
     * 
     * @param ex
     *            exception to process
     * @return error response
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ErrorResponse
            processIllegalArgument(final IllegalArgumentException ex) {
        LOGGER.debug("Intercepted IllegalArgumentException");

        return new DefaultErrorResponse(
                resolveLocalizedErrorMessage(ex.getMessage()));
    }

    /**
     * Returns the message source.
     * 
     * @return the message source
     */
    private final MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * Localizes an error message.
     * 
     * @param error
     *            message to localize
     * @return the localized message
     */
    private final String resolveLocalizedErrorMessage(final String error) {
        final Locale currentLocale;
        String localizedErrorMessage;

        currentLocale = LocaleContextHolder.getLocale();
        try {
            localizedErrorMessage = getMessageSource().getMessage(error,
                    new Object[] {}, currentLocale);
        } catch (final NoSuchMessageException e) {
            localizedErrorMessage = error;
        }

        return localizedErrorMessage;
    }

}
