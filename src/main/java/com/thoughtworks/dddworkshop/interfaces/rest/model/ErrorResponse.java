package com.thoughtworks.dddworkshop.interfaces.rest.model;


import com.thoughtworks.dddworkshop.infrastructure.util.i18n.I18nMessage;
import lombok.Data;

import java.util.Set;

@Data
public class ErrorResponse {
    private Set<I18nMessage> errors;
}
