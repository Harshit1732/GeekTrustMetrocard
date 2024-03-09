package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Passenger;

public interface Passengerrepositoryservice {

    Passenger saveData(Passenger passenger);

    Passenger getPassenger(Passenger passenger);

}
