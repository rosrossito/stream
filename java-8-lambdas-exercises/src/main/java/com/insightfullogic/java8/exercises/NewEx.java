package com.insightfullogic.java8.exercises;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NewEx {

    BufferedReader reader;

    public NewEx(BufferedReader reader) {
        this.reader = reader;
    }

    final String REGEXP = "\\W+"; // for splitting into words

    public void zzz1(){
    List<String> output =
            reader.lines()
                .flatMap(line -> Stream.of(line.split(REGEXP)))
                .filter(word -> word.length() > 0)
                .collect(toList());
    }
}
