package com.geektrust.backend.services.checkIn;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;

public interface CheckInservice {
    void checkIn(MetroCard card, Passenger passenger, Station station);
}
