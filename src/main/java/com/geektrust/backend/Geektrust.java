package com.geektrust.backend;

import com.geektrust.backend.Commands.CommandInvoker;
import com.geektrust.backend.Configuration.ApplicationConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Geektrust {

    public static void main(String[] args) {

        try {
            ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
            CommandInvoker commandInvoker = applicationConfiguration.getCommandInvoker();
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                List<String> tokens = Arrays.asList(sc.nextLine().split(" "));
                commandInvoker.executeCommand(tokens.get(0), tokens);
            }
            sc.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}



