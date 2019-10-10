package com.thoughtworks.dddworkshop.domain.vo;

import com.thoughtworks.dddworkshop.domain.shared.RandomUUID;

public class PaymentId extends RandomUUID {

    public PaymentId() {
        super();
    }

    public PaymentId(String id) {
        super(id);
    }

    @Override
    protected String getPrefix() {
        return "PAY-%s";
    }
}
