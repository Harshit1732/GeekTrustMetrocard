package com.geektrust.backend.services;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.repositories.Metrocardrepositoryservice;
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
@DisplayName("Metrocard service Test")
public class MetrocardserviceTest {

    @Mock
    private Metrocardrepositoryservice metrocardrepositoryservice;

    @InjectMocks
    private MetrocardserviceImpl metrocardservice;

    @Test
    @DisplayName("save card Should save the Card")
    public void saveMetrocard_shouldSaveCard() {
        MetroCard card = new MetroCard("MC1", 600);
        when(metrocardrepositoryservice.saveData(any(MetroCard.class))).thenReturn(card);
        MetroCard actualCard = metrocardservice.saveCard(card);
        assertEquals(card, actualCard);
        assertEquals(card.getCardNumber(), actualCard.getCardNumber());
        assertEquals(card.getBalance(), actualCard.getBalance());
    }

}
