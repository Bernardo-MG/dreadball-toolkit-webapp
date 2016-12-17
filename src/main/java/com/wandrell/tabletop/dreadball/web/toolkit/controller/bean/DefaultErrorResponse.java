
package com.wandrell.tabletop.dreadball.web.toolkit.controller.bean;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultErrorResponse implements ErrorResponse {

    private final String message;

    public DefaultErrorResponse(final String message) {
        super();

        this.message = checkNotNull(message,
                "Received a null pointer as message");
    }

    @Override
    public final String getMessage() {
        return message;
    }

}
