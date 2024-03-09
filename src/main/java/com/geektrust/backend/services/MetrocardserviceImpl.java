package com.geektrust.backend.services;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.repositories.Metrocardrepositoryservice;

public class MetrocardserviceImpl implements Metrocardservice {

    private final Metrocardrepositoryservice metrocardrepositoryservice;

    public MetrocardserviceImpl(Metrocardrepositoryservice metrocardrepositoryservice) {
        this.metrocardrepositoryservice = metrocardrepositoryservice;
    }

    @Override
    public MetroCard saveCard(MetroCard card) {
        return metrocardrepositoryservice.saveData(card);
    }

    @Override
    public MetroCard getCard(MetroCard card) {
        return metrocardrepositoryservice.getCard(card);
    }
}
