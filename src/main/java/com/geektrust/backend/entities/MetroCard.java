package com.geektrust.backend.entities;

public class MetroCard {
    private final String cardNumber;

    private Integer balance;

    public MetroCard(String cardNumber, Integer balance) {
        this.balance = balance;
        this.cardNumber = cardNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

}
