package com.marco.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PaymentOptions {

    // fields
    @Id
    private String id;
    private PaymentType paymentType;
    private int fee;

    // constructor
    public PaymentOptions(PaymentType paymentType, int fee) {
        this.paymentType = paymentType;
        this.fee = fee;
    }

    // methods
    public PaymentType getPaymentType() {
        return paymentType;
    }

    public int getFee() {
        return fee;
    }
}
