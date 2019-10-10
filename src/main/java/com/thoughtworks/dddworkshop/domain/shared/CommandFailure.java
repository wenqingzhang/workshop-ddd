package com.thoughtworks.dddworkshop.domain.shared;

import com.thoughtworks.dddworkshop.infrastructure.util.i18n.I18nCode;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class CommandFailure {
    public final Set<I18nCode> codes;
}
