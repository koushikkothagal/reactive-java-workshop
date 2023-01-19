package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("1: ");
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("2: ");
        StreamSources.intNumbersStream().filter(t -> t < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("3: ");
//        AtomicInteger count = new AtomicInteger(0);
//        StreamSources.intNumbersStream().filter(t -> t > 5).forEach(t -> {
//            count.set(count.get() + 1);
//            if (count.get() == 2 || count.get() == 3) System.out.println(t);
//        });

        StreamSources.intNumbersStream().filter(t -> t > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("4: ");
        StreamSources.intNumbersStream().filter(x -> x > 5).findFirst().ifPresentOrElse(System.out::println, () -> {
            System.out.println(-1);
        });

        // Print first names of all users in userStream
        System.out.println("5: ");
        StreamSources.userStream().map(user -> user.getFirstName()).forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("6: ");
        StreamSources.userStream().filter(user -> StreamSources.intNumbersStream()
                        .anyMatch(x -> x == user.getId()))
                .map(user -> user.getFirstName()).forEach(System.out::println);

        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

    }

}
