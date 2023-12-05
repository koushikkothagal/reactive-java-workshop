package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream()
                .forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("Print the first number in intNumbersStream that's greater than 5. If nothing is found print -1");
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println(-1));

        // Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        System.out.println("First solution with flatMap");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(u -> u.getId() == id))
                .map(User::getFirstName)
                .forEach(System.out::println);

        System.out.println("Outra forma de fazer (nao entendi exatamente o pq a forma acima pode ser buggy");
        StreamSources.userStream()
                .filter(u ->
                        StreamSources.intNumbersStream().anyMatch(id -> id == u.getId())
                )
                .map(User::getFirstName)
                .forEach(System.out::println);

    }

}
