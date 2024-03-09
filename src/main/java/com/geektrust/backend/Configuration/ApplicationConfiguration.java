package com.geektrust.backend.Configuration;

import com.geektrust.backend.Commands.BalanceCommand;
import com.geektrust.backend.Commands.CheckInCommand;
import com.geektrust.backend.Commands.CommandInvoker;
import com.geektrust.backend.Commands.PrintSummaryCommand;
import com.geektrust.backend.repositories.*;
import com.geektrust.backend.services.*;

public class ApplicationConfiguration {

    //respositories
    private final Metrocardrepositoryservice metrocardrepositoryservice = new MetrocardrepositoryserviceImpl();
    private final Passengerrepositoryservice passengerrepositoryservice = new PassengerrepositoryserviceImpl();
    private final Stationrepositoryservice stationrepositoryservice = new StationrepositoryserviceImpl();


    //services
    private final Metrocardservice metrocardservice = new MetrocardserviceImpl(metrocardrepositoryservice);
    private final BalanceCommand balanceCommand = new BalanceCommand(metrocardservice);
    private final Passengerservice passengerservice = new PassengerserviceImpl(passengerrepositoryservice);


    //Commands
    private final Stationservice stationservice = new StationserviceImpl(metrocardservice, stationrepositoryservice, passengerservice);
    private final CheckInCommand checkInCommand = new CheckInCommand(stationservice);
    private final PrintSummaryCommand printSummaryCommand = new PrintSummaryCommand(stationservice);


    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.register("BALANCE", balanceCommand);
        commandInvoker.register("CHECK_IN", checkInCommand);
        commandInvoker.register("PRINT_SUMMARY", printSummaryCommand);
        return commandInvoker;
    }

}
