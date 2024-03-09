package com.geektrust.backend.services;

import com.geektrust.backend.entities.MetroCard;

public interface Metrocardservice {
    MetroCard saveCard(MetroCard card);

    MetroCard getCard(MetroCard card);
}
