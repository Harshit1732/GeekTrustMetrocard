package com.geektrust.backend.services;

import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.repositories.Passengerrepositoryservice;

public class PassengerserviceImpl implements Passengerservice {
    private final Passengerrepositoryservice passengerrepositoryservice;

    public PassengerserviceImpl(Passengerrepositoryservice passengerrepositoryservice) {
        this.passengerrepositoryservice = passengerrepositoryservice;
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerrepositoryservice.saveData(passenger);
    }

    @Override
    public Passenger getPassenger(Passenger passenger) {
        return passengerrepositoryservice.getPassenger(passenger);
    }
}
