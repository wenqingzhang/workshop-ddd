package com.thoughtworks.dddworkshop.business;

import com.thoughtworks.dddworkshop.utils.i18n.I18nCode;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class ProcessFailure {
    public final Set<I18nCode> codes;
}
