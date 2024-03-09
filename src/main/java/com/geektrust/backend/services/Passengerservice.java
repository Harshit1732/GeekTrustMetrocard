package com.geektrust.backend.services;

import com.geektrust.backend.entities.Passenger;

public interface Passengerservice {

    Passenger savePassenger(Passenger passenger);

    Passenger getPassenger(Passenger passenger);
}
