package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Exercise6 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()
    Flux<String> unresponsiveFlux = ReactiveSources.unresponsiveFlux();
    Mono<String> unresponsiveMono = ReactiveSources.unresponsiveMono();

    // Get the value from the Mono into a String variable but give up after 5 seconds
    String valueFromMono =
        unresponsiveMono
            .timeout(Duration.ofSeconds(5L))
            .doOnError(
                e ->
                    System.out.println(
                        "Could not retrieve the value from unresponsiveMono within 5 seconds"))
            .onErrorReturn("")
            .block();
    System.out.println(valueFromMono);

    // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
    List<String> valueFromFlux =
        unresponsiveFlux
            .timeout(Duration.ofSeconds(5L))
            .doOnError(
                e ->
                    System.out.println(
                        "Could not retrieve the value from unresponsiveFlux within 5 seconds"))
            .onErrorReturn("")
            .collectList()
            .block();

    System.out.println(valueFromFlux);

    System.out.println("Press a key to end");
    System.in.read();
  }
}
