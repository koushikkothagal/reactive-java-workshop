package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;

public class Exercise4 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumberMono()
    Mono<Integer> intNumberMono = ReactiveSources.intNumberMono();

    // Print the value from intNumberMono when it emits
    intNumberMono.subscribe(System.out::println);

    // Get the value from the Mono into an integer variable
    Integer integer = intNumberMono.block();
    System.out.println("Integer value: " + integer);

    System.out.println("Press a key to end");
    System.in.read();
  }
}
