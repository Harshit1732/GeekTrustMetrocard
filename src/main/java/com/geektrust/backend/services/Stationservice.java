package com.geektrust.backend.services;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;

import java.util.List;

public interface Stationservice {

    void checkIn(MetroCard card, Passenger passenger, Station station);

    List<Station> getStationsInformation();

}

