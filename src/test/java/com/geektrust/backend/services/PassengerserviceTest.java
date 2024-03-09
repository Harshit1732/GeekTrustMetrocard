package com.geektrust.backend.services;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.repositories.Passengerrepositoryservice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@DisplayName("Passenger service Test")
public class PassengerserviceTest {
    @Mock
    private Passengerrepositoryservice passengerrepositoryservice;
    @InjectMocks
    private PassengerserviceImpl passengerservice;

    @Test
    @DisplayName("save Passenger Should save the Passenger")
    public void savePassenger_shouldSavePassenger() {
        MetroCard card = new MetroCard("MC1", 600);
        Passenger passenger = new Passenger(PassengerType.ADULT, card, false);
        when(passengerrepositoryservice.saveData(any(Passenger.class))).thenReturn(passenger);
        Passenger actualPassenger = passengerservice.savePassenger(passenger);
        assertEquals(passenger, actualPassenger);
        assertEquals(passenger.getPassengerType(), actualPassenger.getPassengerType());
        assertEquals(card, actualPassenger.getCard());
    }

}
