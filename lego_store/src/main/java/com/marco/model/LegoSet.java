package com.marco.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Document(collection = "legosets")
public class LegoSet {
    //fields
    @Id
    private String id;

    @TextIndexed
    private String name;

    private LegoDifficulty difficulty;

    @TextIndexed
    @Indexed(direction = IndexDirection.ASCENDING)
    private String theme;

    private Collection<ProductReview> reviews = new ArrayList<ProductReview>();
    @Field("delivery")
    private DeliveryInfo deliveryInfo;

    private int nbParts;

    @DBRef
    private PaymentOptions paymentOptions;

    // constructor
    @PersistenceConstructor
    public LegoSet(String name,
                   String theme,
                   LegoDifficulty difficulty,
                   DeliveryInfo deliveryInfo,
                   Collection<ProductReview> reviews,
                   PaymentOptions paymentOptions) {
        this.name = name;
        this.difficulty = difficulty;
        this.theme = theme;
        this.reviews = reviews;
        this.deliveryInfo = deliveryInfo;
        this.paymentOptions  = paymentOptions;
    }

    // methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LegoDifficulty getDifficulty() {
        return difficulty;
    }

    public String getTheme() {
        return theme;
    }

    public Collection<ProductReview> getReviews() {
        return Collections.unmodifiableCollection(this.reviews);
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public int getNbParts() {
        return nbParts;
    }

    public PaymentOptions getPaymentOptions() {
        return paymentOptions;
    }
}
