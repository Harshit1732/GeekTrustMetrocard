package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Station;

import java.util.List;

public interface Stationrepositoryservice {

    Station saveData(Station station);

    List<Station> getStations();

    Station getStation(Station station);
}
