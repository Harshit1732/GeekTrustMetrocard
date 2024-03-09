package com.geektrust.backend.services;

import com.geektrust.backend.Constants.CommonConstant;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;
import com.geektrust.backend.repositories.Stationrepositoryservice;

import java.util.HashMap;
import java.util.List;

public class StationserviceImpl implements Stationservice {
    private final Metrocardservice metrocardservice;
    private final Stationrepositoryservice stationrepositoryservice;
    private final Passengerservice passengerservice;

    public StationserviceImpl(Metrocardservice metrocardservice, Stationrepositoryservice stationrepositoryservice, Passengerservice passengerservice) {
        this.metrocardservice = metrocardservice;
        this.stationrepositoryservice = stationrepositoryservice;
        this.passengerservice = passengerservice;
    }


    ////check In At Station.......
    @Override
    public void checkIn(MetroCard card, Passenger passenger, Station station) {
        //fetching data from Repository
        MetroCard fetchCard = getMetrocard(card);
        Station fetchStation = fetchStation(station);
        Passenger fetchPassenger = fetchPassenger(passenger);

        //initialising variables...
        HashMap<String, Integer> passengerCount = fetchStation.getPassengerCount();
        Integer cardBalance = fetchCard.getBalance();
        Integer Collection = CommonConstant.ZERO;
        Integer discountCollection = CommonConstant.ZERO;
        Integer charges = CommonConstant.ZERO;
        //checking the passenger Return journey...
        //setChargesandDiscountCollection(fetchPassenger, charges, discountCollection);
        if (fetchPassenger.isHasmadejourney()) {
            charges = (int) (fetchPassenger.getPassengerType().getval() * CommonConstant.HALF);
            fetchPassenger.setHasmadejourney(false);
            discountCollection = charges;
        } else {
            charges = fetchPassenger.getPassengerType().getval();
            fetchPassenger.setHasmadejourney(true);
        }

        // checking Cardbalance and set Balance...
        if (cardBalance >= charges) {
            Collection = charges;
            fetchCard.setBalance((fetchCard.getBalance() - charges));
        } else {
            Integer remainingCharges = charges - cardBalance;
            Collection = (int) (remainingCharges * CommonConstant.PER) + charges;
            fetchCard.setBalance(CommonConstant.ZERO);
        }

        ///set the Passenger Count At Station....
        if (passengerCount.containsKey(fetchPassenger.getPassengerType().toString())) {
            int c = passengerCount.get(fetchPassenger.getPassengerType().toString());
            passengerCount.put(fetchPassenger.getPassengerType().toString(), c + CommonConstant.ONE);
        } else {
            passengerCount.put(fetchPassenger.getPassengerType().toString(), CommonConstant.ONE);
        }

        // Variable Setting....
        fetchStation.setTotalCollection(fetchStation.getTotalCollection() + Collection);
        fetchStation.setTotalDiscount(fetchStation.getTotalDiscount() + discountCollection);
        fetchStation.setPassengerCount(passengerCount);

        /// Saving data to Repo...
        stationrepositoryservice.saveData(fetchStation);
        passengerservice.savePassenger(fetchPassenger);
    }


    ///getting stations Data.....
    @Override
    public List<Station> getStationsInformation() {
        return stationrepositoryservice.getStations();
    }

    ///getting Metrocard from Repo.....
    public MetroCard getMetrocard(MetroCard card) {
        return metrocardservice.getCard(card);
    }

    //getting Station from Repo.....
    public Station fetchStation(Station station) {
        Station fetchStation = stationrepositoryservice.getStation(station);
        if (fetchStation == null) {
            return station;
        }
        return fetchStation;
    }

    //getting  Passenger from Repo.......
    public Passenger fetchPassenger(Passenger passenger) {
        Passenger fetchPassenger = passengerservice.getPassenger(passenger);
        if (fetchPassenger == null) {
            return passenger;
        }
        return fetchPassenger;
    }

    public void setChargesandDiscountCollection(Passenger passenger, Integer charges, Integer discountCollection) {
        if (passenger.isHasmadejourney()) {
            charges = (int) (passenger.getPassengerType().getval() * CommonConstant.HALF);
            passenger.setHasmadejourney(false);
            discountCollection = charges;
        } else {
            charges = passenger.getPassengerType().getval();
            passenger.setHasmadejourney(true);
        }
    }


}
