
package com.wandrell.tabletop.dreadball.web.toolkit.controller.bean;

import static com.google.common.base.Preconditions.checkNotNull;

public final class ErrorResponse {

    private final String message;

    public ErrorResponse(final String message) {
        super();

        this.message = checkNotNull(message,
                "Received a null pointer as message");
    }

    public final String getMessage() {
        return message;
    }

}
