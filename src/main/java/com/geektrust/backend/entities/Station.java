package com.geektrust.backend.entities;

import java.util.HashMap;

public class Station {

    private StationType stationType;
    private Integer totalCollection;
    private Integer totalDiscount;
    private HashMap<String, Integer> passengerCount;

    public Station(StationType stationType, Integer totalCollection, Integer totalDiscount) {
        this.stationType = stationType;
        this.totalDiscount = totalDiscount;
        this.totalCollection = totalCollection;
        this.passengerCount = new HashMap<>();
    }

    public StationType getStationType() {
        return stationType;
    }

    public void setStationType(StationType stationType) {
        this.stationType = stationType;
    }

    public HashMap<String, Integer> getPassengerCount() {
        return this.passengerCount;
    }

    public void setPassengerCount(HashMap<String, Integer> passengerCount) {
        this.passengerCount = passengerCount;
    }

    public Integer getTotalCollection() {
        return this.totalCollection;
    }

    public void setTotalCollection(Integer totalCollection) {
        this.totalCollection = totalCollection;
    }

    public Integer getTotalDiscount() {
        return this.totalDiscount;
    }

    public void setTotalDiscount(Integer totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

}
