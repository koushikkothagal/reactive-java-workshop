package io.javabrains.reactiveworkshop;

import java.util.List;

public class Exercise1 {

  public static void main(String[] args) {

    // Use StreamSources.intNumbersStream() and StreamSources.userStream()

    // Print all numbers in the intNumbersStream stream
    StreamSources.intNumbersStream().forEach(System.out::println);

    // Print numbers from intNumbersStream that are less than 5
    StreamSources.intNumbersStream().filter(number -> number < 5).forEach(System.out::println);

    // Print the second and third numbers in intNumbersStream that's greater than 5
    StreamSources.intNumbersStream()
        .filter(number -> number > 5)
        .skip(1L)
        .limit(2)
        .forEach(System.out::println);

    //  Print the first number in intNumbersStream that's greater than 5.
    //  If nothing is found, print -1
    Integer integer =
        StreamSources.intNumbersStream().filter(number -> number > 5).findFirst().orElse(-1);
    System.out.println(integer);

    // Print first names of all users in userStream
    StreamSources.userStream().map(User::getFirstName).forEach(System.out::println);

    // Print first names in userStream for users that have IDs from number stream
    //    Solution-1
    StreamSources.intNumbersStream()
        .flatMap(userId -> StreamSources.userStream().filter(user -> user.getId() == userId))
        .map(User::getFirstName)
        .forEachOrdered(System.out::println);
    //   Solution-2
    List<Integer> userIds = StreamSources.intNumbersStream().toList();
    StreamSources.userStream()
        .filter(user -> userIds.contains(user.getId()))
        .map(User::getFirstName)
        .forEach(System.out::println);
  }
}
