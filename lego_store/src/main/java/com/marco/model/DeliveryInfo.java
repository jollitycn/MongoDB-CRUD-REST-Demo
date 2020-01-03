package com.marco.model;

import java.time.LocalDate;

public class DeliveryInfo {
    //fields
    private LocalDate deliveryDate;
    private int deliveryFee;
    private boolean inStock;

    // constructor
    public DeliveryInfo(LocalDate deliveryDate, int deliveryFee, boolean inStock) {
        this.deliveryDate = deliveryDate;
        this.deliveryFee = deliveryFee;
        this.inStock = inStock;
    }

    // methods
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public boolean isInStock() {
        return inStock;
    }
}
