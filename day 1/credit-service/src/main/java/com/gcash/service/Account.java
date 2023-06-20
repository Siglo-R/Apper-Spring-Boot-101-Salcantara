package com.gcash.service;


import lombok.Data;

@Data
public class Account {

    private String id;
    private Double balance;


    //Boiler Plates Getter and Setter
    /*
    public String getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

     */
}
