package com.geektrust.backend.services;

import com.geektrust.backend.repositories.Metrocardrepositoryservice;
import com.geektrust.backend.services.Metrocard.MetrocardserviceImpl;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;



@DisplayName("Metrocard service Test")
public class MetrocardserviceTest {


    private Metrocardrepositoryservice metrocardrepositoryservice;


    private MetrocardserviceImpl metrocardservice;


//    @DisplayName("save card Should save the Card")
//    public void saveMetrocard_shouldSaveCard() {
//        MetroCard card = new MetroCard("MC1", 600);
//        when(metrocardrepositoryservice.saveData(any(MetroCard.class))).thenReturn(card);
//        MetroCard actualCard = metrocardservice.saveCard(card);
//        assertEquals(card, actualCard);
//        assertEquals(card.getCardNumber(), actualCard.getCardNumber());
//        assertEquals(card.getBalance(), actualCard.getBalance());
//    }

}
