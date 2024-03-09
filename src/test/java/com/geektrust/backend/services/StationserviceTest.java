package com.geektrust.backend.services;

import com.geektrust.backend.entities.*;
import com.geektrust.backend.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Station Service Test")
public class StationserviceTest {

    private Passengerrepositoryservice passengerrepositoryservice;

    private Metrocardrepositoryservice metrocardrepositoryservice;
    private Stationrepositoryservice stationrepositoryservice;

    private PassengerserviceImpl passengerservice;
    private MetrocardserviceImpl metrocardservice;
    private StationserviceImpl stationservice;

    @BeforeEach
    void setup() {
        this.metrocardrepositoryservice = new MetrocardrepositoryserviceImpl();
        this.passengerrepositoryservice = new PassengerrepositoryserviceImpl();
        this.stationrepositoryservice = new StationrepositoryserviceImpl();
        this.metrocardservice = new MetrocardserviceImpl(this.metrocardrepositoryservice);
        this.passengerservice = new PassengerserviceImpl(this.passengerrepositoryservice);
        this.stationservice = new StationserviceImpl(metrocardservice, stationrepositoryservice, passengerservice);
        MetroCard card1 = new MetroCard("MC1", 600);
        MetroCard card2 = new MetroCard("MC2", 200);
        MetroCard card3 = new MetroCard("MC3", 50);
        metrocardservice.saveCard(card1);
        metrocardservice.saveCard(card2);
        metrocardservice.saveCard(card3);
    }


    @Test
    @DisplayName("ADULT checkIN")
    public void testcheckIN_ADULT() {
        MetroCard card = new MetroCard("MC1", 600);
        Passenger passenger = new Passenger(PassengerType.ADULT, card, false);
        Station station = new Station(StationType.CENTRAL, 0, 0);
        stationrepositoryservice.saveData(station);
        stationservice.checkIn(card, passenger, station);
        assertEquals((Integer) 200, station.getTotalCollection());
        assertEquals((Integer) 0, station.getTotalDiscount());
    }

    @Test
    @DisplayName("KID checkIN")
    public void testcheckIN_KID() {
        MetroCard card = new MetroCard("MC3", 50);
        Passenger passenger = new Passenger(PassengerType.KID, card, false);
        Station station = new Station(StationType.CENTRAL, 0, 0);
        stationrepositoryservice.saveData(station);
        stationservice.checkIn(card, passenger, station);
        assertEquals((Integer) 50, station.getTotalCollection());
        assertEquals((Integer) 0, station.getTotalDiscount());
    }

    @Test
    @DisplayName("ADULT Return checkIN")
    public void testcheckIN_ADULT_RETURNS_checkIn() {
        MetroCard card = new MetroCard("MC1", 600);
        Passenger passenger = new Passenger(PassengerType.ADULT, card, true);
        Station station = new Station(StationType.AIRPORT, 0, 0);
        stationrepositoryservice.saveData(station);
        stationservice.checkIn(card, passenger, station);
        assertEquals((Integer) 100, station.getTotalCollection());
        assertEquals((Integer) 100, station.getTotalDiscount());
    }


}
