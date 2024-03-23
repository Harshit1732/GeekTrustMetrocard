package com.geektrust.backend.services.checkIn;

import com.geektrust.backend.Constants.CommonConstant;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;
import com.geektrust.backend.services.Metrocard.Metrocardservice;
import com.geektrust.backend.services.Passenger.Passengerservice;
import com.geektrust.backend.services.Station.Stationservice;

import java.util.HashMap;

public class CheckInserviceImpl implements CheckInservice {

    private final Metrocardservice metrocardservice;
    private final Stationservice stationservice;
    private final Passengerservice passengerservice;

    public CheckInserviceImpl(Metrocardservice metrocardservice, Stationservice stationservice, Passengerservice passengerservice) {
        this.metrocardservice = metrocardservice;
        this.stationservice = stationservice;
        this.passengerservice = passengerservice;
    }

    @Override
    public void checkIn(MetroCard card, Passenger passenger, Station station) {
        Integer []charges= calculateCharges(passengerservice.getPassenger(passenger));
        Integer collection= adjustCardBalance(metrocardservice.getCard(card),charges[CommonConstant.ZERO]);
        updateStationData(passengerservice.getPassenger(passenger),stationservice.getStation(station), charges[CommonConstant.ONE], collection);
        savePassengerAndStation(passengerservice.getPassenger(passenger),stationservice.getStation(station));
    }

    private void updateStationData(Passenger passenger,Station station, Integer charges, Integer collection) {
        HashMap<String, Integer> passengerCount = stationservice.updateStationPassenger(passenger, station);
        stationservice.updateStationData(stationservice.getStation(station), collection, charges, passengerCount);
    }

    private Integer[] calculateCharges(Passenger passenger) {
        Integer charges = passengerservice.getPassengerJourney(passenger) ? (int) (passenger.getPassengerType().getval() * CommonConstant.HALF) : passenger.getPassengerType().getval();
        Integer discount = passengerservice.getPassengerJourney(passenger)? charges : CommonConstant.ZERO;
        passengerservice.setPassengerJourney(passenger, !passengerservice.getPassengerJourney(passenger));
        return new Integer[]{charges,discount};
    }

    private Integer adjustCardBalance(MetroCard card, Integer charges) {
        Integer cardBalance = metrocardservice.getCardBalance(card);
        Integer remainingCharges= Math.max(CommonConstant.ZERO,charges-cardBalance);
        Integer updatedCardBalance= remainingCharges==0?cardBalance-charges:CommonConstant.ZERO;
        metrocardservice.updateBalance(card,updatedCardBalance);
        return cardBalance>=charges?charges:(int)(remainingCharges * CommonConstant.PER) + charges;
    }

    private void savePassengerAndStation(Passenger passenger, Station station) {
        passengerservice.savePassenger(passenger);
        stationservice.saveStation(station);
    }
}
