package com.geektrust.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("App Test")
class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Integration Test")
    public void Application_Test() throws Exception {

        String[] args = {"sample_input/input1.txt"};

        String expectedOutput = "TOTAL_COLLECTION CENTRAL 300 0\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 1\n" +
                "SENIOR_CITIZEN 1\n" +
                "TOTAL_COLLECTION AIRPORT 403 100\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 2\n" +
                "KID 2";
        Geektrust.main(args);

        String actualOutput = outputStreamCaptor.toString().trim();


        //expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");

        //System.out.println(outputStreamCaptor.toString().trim());
        Assertions.assertEquals(expectedOutput, actualOutput.trim());
    }

}
