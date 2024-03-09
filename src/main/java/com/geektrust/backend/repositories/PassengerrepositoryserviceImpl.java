package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Passenger;

import java.util.HashMap;

public class PassengerrepositoryserviceImpl implements Passengerrepositoryservice {

    private final HashMap<String, Passenger> passengerMap;

    public PassengerrepositoryserviceImpl() {
        this.passengerMap = new HashMap<>();
    }

    @Override
    public Passenger saveData(Passenger passenger) {
        passengerMap.put(passenger.getCard().getCardNumber(), passenger);
        return passenger;
    }

    @Override
    public Passenger getPassenger(Passenger passenger) {
        return passengerMap.get(passenger.getCard().getCardNumber());
    }

}
