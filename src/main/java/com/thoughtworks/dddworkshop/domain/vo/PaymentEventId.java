package com.thoughtworks.dddworkshop.domain.vo;

import com.thoughtworks.dddworkshop.domain.shared.RandomUUID;


public class PaymentEventId extends RandomUUID {

    @Override
    protected String getPrefix() {
        return "PEV-%s";
    }
}