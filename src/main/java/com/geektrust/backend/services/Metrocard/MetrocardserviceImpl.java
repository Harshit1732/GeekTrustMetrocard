package com.geektrust.backend.services.Metrocard;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.repositories.Metrocardrepositoryservice;
import com.geektrust.backend.services.Metrocard.Metrocardservice;

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

    @Override
    public void updateBalance(MetroCard card,Integer balance) {
        card.setBalance(balance);
        saveCard(card);
    }

    @Override
    public Integer getCardBalance(MetroCard card) {
        return card.getBalance();
    }


}
