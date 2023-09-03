package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()


        // TODO: Write code here
        // NOTE : non-blocking call
        ReactiveSources.intNumberMono().subscribe(number -> System.out.println(number));

        // Get the value from the Mono into an integer variable
        // NOTE : blocking call
        Integer number = ReactiveSources.intNumberMono().block();
        System.out.println("After blocking: " + number);

        // OR

        Optional<Integer> numberOptional = ReactiveSources.intNumberMono().blockOptional();
        System.out.println("After blocking optional: " + (numberOptional.isPresent() ? numberOptional.get() : 0));

        // NOTE : Mono can return  a list


        System.out.println("Press a key to end");
        System.in.read();
    }

}
