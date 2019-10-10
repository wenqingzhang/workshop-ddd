package com.thoughtworks.dddworkshop.models;

import com.thoughtworks.dddworkshop.utils.i18n.I18nMessage;
import lombok.Data;

import java.util.Set;

@Data
public class ErrorResponse {
    private Set<I18nMessage> errors;
}
