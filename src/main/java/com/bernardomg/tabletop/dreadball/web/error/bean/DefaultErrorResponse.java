/**
 * Copyright 2018 the original author or authors
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

package com.bernardomg.tabletop.dreadball.web.error.bean;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Default implementation of {@link ErrorResponse}.
 * <p>
 * FIXME: Isn't this annotated to generate a SOAP message? Change to JSON
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public final class DefaultErrorResponse implements ErrorResponse {

    /**
     * Error message.
     */
    @XmlElement(name = "message")
    private String message;

    /**
     * Constructs a response.
     */
    public DefaultErrorResponse() {
        super();
    }

    /**
     * Constructs a response.
     * 
     * @param msg
     *            error message
     */
    public DefaultErrorResponse(final String msg) {
        super();

        message = checkNotNull(msg, "Received a null pointer as message");
    }

    @Override
    public final String getMessage() {
        return message;
    }

    /**
     * Sets the error message.
     * 
     * @param msg
     *            the error message
     */
    public final void setMessage(final String msg) {
        message = msg;
    }

}
