package com.anandCodes.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("transactions")
public class Transactions {
    @Id
    private String id;
    private String userId;
    private Integer amount;
    private String timeStamp;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String reference;

    public Transactions(){

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Transactions(Integer amount, String timeStamp){
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.reference = "eating out at mcdonalds";

    }


}
