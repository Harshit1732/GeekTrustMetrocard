package com.geektrust.backend.Commands;

import com.geektrust.backend.Constants.CommonConstant;
import com.geektrust.backend.entities.*;
import com.geektrust.backend.services.Stationservice;

import java.util.List;

public class CheckInCommand implements Icommand {

    private final Stationservice stationservice;

    public CheckInCommand(Stationservice stationservice) {
        this.stationservice = stationservice;
    }

    @Override
    public void execute(List<String> tokens) {
        // System.out.println(tokens.get(0) + " " + tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3));
        MetroCard card = new MetroCard(tokens.get(CommonConstant.ONE), CommonConstant.ZERO);
        Passenger passenger = new Passenger(PassengerType.valueOf(tokens.get(CommonConstant.TWO)), card, false);
        Station station = new Station(StationType.valueOf(tokens.get(CommonConstant.THREE)), CommonConstant.ZERO, CommonConstant.ZERO);
        stationservice.checkIn(card, passenger, station);
    }
}
