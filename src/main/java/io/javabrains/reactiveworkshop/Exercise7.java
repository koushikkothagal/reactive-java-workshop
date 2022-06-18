package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise7 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

    Flux<Integer> intNumbersFlux = ReactiveSources.intNumbersFlux();
    Flux<User> userFLux = ReactiveSources.userFlux();
    Flux<Integer> intNumbersFluxWithRepeat = ReactiveSources.intNumbersFluxWithRepeat();

    // Print all values from intNumbersFlux that's greater than 5
    intNumbersFlux.filter(number -> number > 5).subscribe(System.out::println);

    // Print 10 times each value from intNumbersFlux that's greater than 5
    intNumbersFlux
        .filter(number -> number > 5)
        .map(number -> number * 10)
        .subscribe(System.out::println);

    // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater
    // than 5
    intNumbersFlux
        .filter(number -> number > 5)
        .take(3)
        .map(number -> number * 10)
        .subscribe(System.out::println);
    // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are
    // found
    intNumbersFlux.filter(number -> number > 20).or(Flux.just(-1)).subscribe(System.out::println);

    // Switch ints from intNumbersFlux to the right user from userFlux
    intNumbersFlux
        .flatMap(userId -> userFLux.filter(user -> user.getId() == userId))
        .subscribe(System.out::println);

    // Print only distinct numbers from intNumbersFluxWithRepeat
    intNumbersFluxWithRepeat.distinct().subscribe(System.out::println);

    // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
    intNumbersFluxWithRepeat.distinctUntilChanged().subscribe(System.out::println);

    System.out.println("Press a key to end");
    System.in.read();
  }
}
