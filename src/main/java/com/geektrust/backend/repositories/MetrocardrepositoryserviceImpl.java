package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.MetroCard;

import java.util.HashMap;

public class MetrocardrepositoryserviceImpl implements Metrocardrepositoryservice {
    private final HashMap<String, MetroCard> metroCardMap;

    public MetrocardrepositoryserviceImpl() {
        this.metroCardMap = new HashMap<>();
    }

    @Override
    public MetroCard saveData(MetroCard card) {
        metroCardMap.put(card.getCardNumber(), card);
        return card;
    }

    @Override
    public MetroCard getCard(MetroCard card) {
        return metroCardMap.get(card.getCardNumber());
    }
}
