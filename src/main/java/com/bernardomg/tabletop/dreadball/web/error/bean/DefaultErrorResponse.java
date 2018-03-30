
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
