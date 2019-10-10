package com.thoughtworks.dddworkshop.vo;

public class PaymentEventId extends RandomUUID {

    @Override
    protected String getPrefix() {
        return "PEV-%s";
    }
}