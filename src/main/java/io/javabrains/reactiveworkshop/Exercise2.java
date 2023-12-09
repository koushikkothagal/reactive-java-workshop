package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        System.out.println("Print all numbers in ReactiveSources.intNumbersFlux stream");
        Flux<Integer> integerFlux = ReactiveSources.intNumbersFlux();
        integerFlux.subscribe(System.out::println);
        integerFlux.subscribe(number -> System.out.println("Another subscriber running with number " + number));
        // acima podemos ver um exemplo de varios callbacks sendo subscritos, a ordem de execucao desses callbacks sera nao deterministica

        // Print all users in the ReactiveSources.userFlux stream
        System.out.println("Print all users in the ReactiveSources.userFlux stream");
        ReactiveSources.userFlux()
                        .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
