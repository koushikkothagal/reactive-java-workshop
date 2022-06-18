package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()
    Flux<Integer> intNumbersFlux = ReactiveSources.intNumbersFlux();
    Flux<User> userFlux = ReactiveSources.userFlux();

    // Print all numbers in the ReactiveSources.intNumbersFlux stream
    intNumbersFlux.subscribe(System.out::println);

    // Print all users in the ReactiveSources.userFlux stream
    userFlux.subscribe(System.out::println);

    System.out.println("Press a key to end");
    System.in.read();
  }
}
