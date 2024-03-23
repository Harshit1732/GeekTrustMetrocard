package com.geektrust.backend.services.Passenger;

import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.repositories.Passengerrepositoryservice;
import com.geektrust.backend.services.Passenger.Passengerservice;

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
        Passenger fetchPassenger= passengerrepositoryservice.getPassenger(passenger);
        return fetchPassenger==null?passenger:fetchPassenger;
    }

    @Override
    public boolean getPassengerJourney(Passenger passenger) {
        return passenger.getHasmadejourney();
    }

    @Override
    public void setPassengerJourney(Passenger passenger, boolean journey) {
        passenger.setHasmadejourney(journey);
    }
}
