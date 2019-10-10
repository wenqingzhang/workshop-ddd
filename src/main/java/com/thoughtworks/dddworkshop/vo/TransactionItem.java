package com.thoughtworks.dddworkshop.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode
public class TransactionItem {
    @NotNull
    @Size(min = 3)
    public final String name;
    @Valid
    public final Money price;
    @Min(1)
    public final Integer quantity;

    @JsonCreator
    public TransactionItem(@JsonProperty("name") String name,
                           @JsonProperty("price") Money price,
                           @JsonProperty("quantity") Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}