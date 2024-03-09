package com.geektrust.backend.Commands;

import com.geektrust.backend.Constants.CommonConstant;
import com.geektrust.backend.entities.PassengerType;
import com.geektrust.backend.entities.Station;
import com.geektrust.backend.services.Stationservice;

import java.util.*;

public class PrintSummaryCommand implements Icommand {

    private final Stationservice stationservice;

    public PrintSummaryCommand(Stationservice stationservice) {
        this.stationservice = stationservice;
    }

    @Override
    public void execute(List<String> tokens) {
        // System.out.println(tokens.get(0));
        List<Station> stations = stationservice.getStationsInformation();
        Collections.reverse(stations);
        for (Station s : stations) {
            System.out.println("TOTAL_COLLECTION" + " " + s.getStationType().toString() + " " + s.getTotalCollection() + " " + s.getTotalDiscount());
            System.out.println("PASSENGER_TYPE_SUMMARY");
            List<Map.Entry<String, Integer>> entryList = new ArrayList(s.getPassengerCount().entrySet());
            entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int valueComparison = o2.getValue().compareTo(o1.getValue());
                    if (valueComparison != CommonConstant.ZERO) {
                        // If values are not equal, return the comparison result
                        return valueComparison;
                    } else {
                        // If values are equal, compare based on keys
                        String[] priorityOrder = {PassengerType.ADULT.toString(), PassengerType.KID.toString(), PassengerType.SENIOR_CITIZEN.toString()};
                        int index1 = Arrays.asList(priorityOrder).indexOf(o1.getKey());
                        int index2 = Arrays.asList(priorityOrder).indexOf(o2.getKey());
                        return Integer.compare(index1, index2);
                    }
                }
            });
            entryList.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        }
    }
}
