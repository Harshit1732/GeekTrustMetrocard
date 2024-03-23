package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.MetroCard;

public interface Metrocardrepositoryservice {
    public MetroCard saveData(MetroCard card);
    public MetroCard getCard(MetroCard card);
}
