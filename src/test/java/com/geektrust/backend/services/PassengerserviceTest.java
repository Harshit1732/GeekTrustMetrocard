package com.geektrust.backend.services;

import com.geektrust.backend.repositories.Passengerrepositoryservice;
import com.geektrust.backend.services.Passenger.PassengerserviceImpl;
import org.junit.jupiter.api.DisplayName;


import static org.junit.jupiter.api.Assertions.assertEquals;



@DisplayName("Passenger service Test")
public class PassengerserviceTest {

    private Passengerrepositoryservice passengerrepositoryservice;

    private PassengerserviceImpl passengerservice;


//    @DisplayName("save Passenger Should save the Passenger")
//    public void savePassenger_shouldSavePassenger() {
//        MetroCard card = new MetroCard("MC1", 600);
//        Passenger passenger = new Passenger(PassengerType.ADULT, card, false);
//        when(passengerrepositoryservice.saveData(any(Passenger.class))).thenReturn(passenger);
//        Passenger actualPassenger = passengerservice.savePassenger(passenger);
//        assertEquals(passenger, actualPassenger);
//        assertEquals(passenger.getPassengerType(), actualPassenger.getPassengerType());
//        assertEquals(card, actualPassenger.getCard());
//    }

}
