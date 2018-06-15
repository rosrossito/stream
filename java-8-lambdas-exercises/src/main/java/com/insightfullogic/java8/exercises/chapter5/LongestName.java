package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class LongestName {

    public static Artist byReduce(List<Artist> artists) {
        return
                artists.stream()
                .max(Comparator.comparing(artist -> artist.getName().length()))
                .get();
    }

    public static Optional<Artist> byCollecting(List<Artist> artists) {
        Function<Artist,Integer> getLength = artist -> artist.getName().length();
        return artists.stream()
        .collect(Collectors.maxBy(comparing(getLength)));
    }

}
