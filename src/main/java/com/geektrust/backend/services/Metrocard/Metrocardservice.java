package com.geektrust.backend.services.Metrocard;

import com.geektrust.backend.entities.MetroCard;

public interface Metrocardservice {
    MetroCard saveCard(MetroCard card);
    MetroCard getCard(MetroCard card);

     void updateBalance(MetroCard card, Integer balance);
     Integer getCardBalance(MetroCard card);
}
