package com.geektrust.backend.services.Station;

import com.geektrust.backend.Constants.CommonConstant;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;
import com.geektrust.backend.repositories.Stationrepositoryservice;
import com.geektrust.backend.services.Station.Stationservice;

import java.util.HashMap;
import java.util.List;

public class StationserviceImpl implements Stationservice {

    private final Stationrepositoryservice stationrepositoryservice;

    public StationserviceImpl( Stationrepositoryservice stationrepositoryservice) {
        this.stationrepositoryservice = stationrepositoryservice;
    }

    @Override
    public List<Station> getStationsInformation() {
        return stationrepositoryservice.getStations();
    }

    @Override
    public Station getStation(Station station) {
        Station fetchStation = stationrepositoryservice.getStation(station);
        if (fetchStation == null) {
            return station;
        }
        return fetchStation;
    }

    @Override
    public void updateStationData(Station station, Integer collection, Integer discountCollection, HashMap<String, Integer> passengerCount) {
        station.setTotalCollection(station.getTotalCollection() + collection);
        station.setTotalDiscount(station.getTotalDiscount() + discountCollection);
        station.setPassengerCount(passengerCount);
        saveStation(station);
    }

    @Override
    public HashMap<String, Integer> updateStationPassenger(Passenger passenger, Station station) {
        HashMap<String, Integer> passengerCount = station.getPassengerCount();
        String passengerType = passenger.getPassengerType().toString();
        if (passengerCount.containsKey(passengerType)) {
            int count = passengerCount.get(passengerType);
            passengerCount.put(passengerType, count + CommonConstant.ONE);
        } else {
            passengerCount.put(passengerType, CommonConstant.ONE);
        }
        return passengerCount;
    }

    @Override
    public void saveStation(Station station) {
        stationrepositoryservice.saveData(station);
    }

}
