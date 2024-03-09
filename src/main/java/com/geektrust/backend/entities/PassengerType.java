package com.geektrust.backend.entities;

public enum PassengerType {
    ADULT(200),
    SENIOR_CITIZEN(100),
    KID(50);

    private final Integer val;

    PassengerType(int val) {
        this.val = val;
    }

    public Integer getval() {
        return this.val;
    }

}
