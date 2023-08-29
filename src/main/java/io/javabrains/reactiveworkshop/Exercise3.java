package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here
        List<Integer> intNumbersList = ReactiveSources.intNumbersFlux().toStream().toList();
        //Takes 10s (because delay was set in the flux generation)
        System.out.println("List of numbers: " + intNumbersList);


        System.out.println("Press a key to end");
        System.in.read();
    }

}
