package com.thoughtworks.dddworkshop.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Transaction {
    @Valid
    public final Money amount;
    @NotNull
    @Size(min = 1)
    public final List<TransactionItem> items;

    @JsonCreator
    public Transaction(@JsonProperty("amount") Money amount,
                       @JsonProperty("items") List<TransactionItem> items) {

        this.amount = amount;
        this.items = items;
    }
}