package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Station;

import java.util.*;

public class StationrepositoryserviceImpl implements Stationrepositoryservice {

    private final HashMap<String, Station> stationMap;

    public StationrepositoryserviceImpl() {
        this.stationMap = new HashMap<>();
    }

    @Override
    public Station saveData(Station station) {
        stationMap.put(station.getStationType().toString(), station);
        return station;
    }

    @Override
    public List<Station> getStations() {
        List<Station> stations = new ArrayList<>();
        stationMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .forEach(stations::add);
        return stations;
    }

    @Override
    public Station getStation(Station station) {
        Optional<Station> optionalStation = stationMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(s -> s.getStationType().equals(station.getStationType()))
                .findFirst();
        return optionalStation.orElse(null);
    }

}
