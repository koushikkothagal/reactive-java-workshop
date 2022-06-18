package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumbersFluxWithException()
    Flux<Integer> intNumbersFluxWithException = ReactiveSources.intNumbersFluxWithException();

    // Print values from intNumbersFluxWithException and print a message when error happens
    intNumbersFluxWithException.subscribe(System.out::println, System.out::println);

    // Print values from intNumbersFluxWithException and continue on errors
    intNumbersFluxWithException
        .onErrorContinue((exception, element) -> {})
        .subscribe(System.out::println, System.out::println);

    // Print values from intNumbersFluxWithException and when errors
    // happen, replace with a fallback sequence of -1 and -2
    intNumbersFluxWithException
        .onErrorResume(a -> Flux.just(-1, -2))
        .subscribe(System.out::println, System.out::println);

    System.out.println("Press a key to end");
    System.in.read();
  }
}
