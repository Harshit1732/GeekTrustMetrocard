package com.geektrust.backend.services.Station;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;

import java.util.HashMap;
import java.util.List;

public interface Stationservice {

    List<Station> getStationsInformation();
    public Station getStation(Station station);
    void  updateStationData(Station station, Integer collection, Integer discountCollection, HashMap<String, Integer> passengerCount);
    HashMap<String, Integer> updateStationPassenger(Passenger passenger, Station station);

    void saveStation(Station station);
}

