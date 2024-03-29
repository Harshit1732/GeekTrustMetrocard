package com.geektrust.backend.entities;

public class Passenger {

    private final PassengerType passengerType;
    private final MetroCard card;
    private  boolean hasmadejourney;

    public Passenger(PassengerType passengerType, MetroCard card, boolean hasmadejourney) {
        this.passengerType=passengerType;
        this.card=card;
        this.hasmadejourney=hasmadejourney;
    }

    public boolean getHasmadejourney() {
        return this.hasmadejourney;
    }

    public void setHasmadejourney(boolean hasmadejourney) {
        this.hasmadejourney = hasmadejourney;
    }

    public MetroCard getCard() {
        return this.card;
    }

//    public void setCard(MetroCard card) {
//        this.card = card;
//    }

    public PassengerType getPassengerType() {
        return this.passengerType;
    }

//    public void setPassengerType(PassengerType passengerType) {
//        this.passengerType = passengerType;
//    }

}
