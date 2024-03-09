package com.geektrust.backend.Commands;

import com.geektrust.backend.Constants.CommonConstant;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.services.Metrocardservice;

import java.util.List;

import static java.lang.Integer.parseInt;

public class BalanceCommand implements Icommand {
    private final Metrocardservice metrocardservice;

    public BalanceCommand(Metrocardservice metrocardservice) {
        this.metrocardservice = metrocardservice;
    }

    @Override
    public void execute(List<String> tokens) {
        // System.out.println(tokens.get(0) + " " + tokens.get(1) + " " + tokens.get(2));
        MetroCard card = new MetroCard(tokens.get(CommonConstant.ONE), parseInt(tokens.get(CommonConstant.TWO)));
        metrocardservice.saveCard(card);
    }
}
