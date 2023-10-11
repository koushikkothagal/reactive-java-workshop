package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);

        // // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
        .filter(elem -> elem < 5)
        .forEach(System.out::println);

        // // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
        .filter(elem -> elem > 5)
        .skip(1)
        .limit(2)
        .forEach(System.out::println);

        // //  Print the first number in intNumbersStream that's greater than 5.
        // //  If nothing is found, print -1
        Integer number = StreamSources.intNumbersStream()
        .filter(elem -> elem > 5)
        .findFirst()
        .orElse(-1);
        System.out.println("number : "+number);

        Integer number2 = StreamSources.intNumbersStream()
        .filter(elem -> elem > 5)
        .findFirst()
        .orElse(-1);
        System.out.println("number : "+number2);

        // // Print first names of all users in userStream
        StreamSources.userStream()
            .map(User::getFirstName)
            .forEach(System.out::println);
        

        // // Print first names in userStream for users that have IDs from number stream

        StreamSources.userStream()
        .filter(user -> StreamSources.intNumbersStream().anyMatch(elem -> elem == user.getId()))
        .map(User::getFirstName)
        .forEach(System.out::println);
        

    }

}
