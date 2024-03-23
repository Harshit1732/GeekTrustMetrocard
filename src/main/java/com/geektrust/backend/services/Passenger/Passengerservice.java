package com.geektrust.backend.services.Passenger;

import com.geektrust.backend.entities.Passenger;

public interface Passengerservice {

    Passenger savePassenger(Passenger passenger);

    Passenger getPassenger(Passenger passenger);

    boolean getPassengerJourney(Passenger passenger);

    void setPassengerJourney(Passenger passenger, boolean journey);
}
