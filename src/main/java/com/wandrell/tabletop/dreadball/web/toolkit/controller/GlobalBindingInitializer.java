
package com.wandrell.tabletop.dreadball.web.toolkit.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public final class GlobalBindingInitializer {

    public GlobalBindingInitializer() {
        super();
    }

    @InitBinder
    public final void setAllowedFields(final WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

}
