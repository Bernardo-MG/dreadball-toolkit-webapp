
package com.wandrell.tabletop.dreadball.web.toolkit.controller.bean;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public final class DefaultErrorResponse implements ErrorResponse {

    @XmlElement(name = "message")
    private String message;

    public DefaultErrorResponse() {
        super();
    }

    public DefaultErrorResponse(final String message) {
        super();

        this.message = checkNotNull(message,
                "Received a null pointer as message");
    }

    @Override
    public final String getMessage() {
        return message;
    }

    public final void setMessage(final String message) {
        this.message = message;
    }

}
