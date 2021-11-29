package ru.job4j.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Value.values())
                .flatMap(e -> Stream.of(Suit.values())
                        .map(i -> e + " " + i))
                .forEach(System.out::println);
    }
}

