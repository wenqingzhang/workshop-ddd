package com.thoughtworks.dddworkshop.vo;

public class CustomerId extends RandomUUID {

    public CustomerId(String id) {
        super(id);
    }

    @Override
    protected String getPrefix() {
        return "CST-%s";
    }
}
