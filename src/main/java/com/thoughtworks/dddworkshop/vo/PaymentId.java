package com.thoughtworks.dddworkshop.vo;

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
