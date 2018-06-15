package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.exercises.Exercises;
import com.insightfullogic.java8.exercises.NewEx;
import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.*;

public class Question1 {
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, x) -> acc + x);
    }

    public static List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(toList());
    }

    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return
                input.stream()
                        .filter(album -> album.getTrackList().size() <= 3)
                        .collect(toList());
    }

    public static void zzz() throws IOException {
//        IntStream.range(1, 5)
//                .flatMap(i -> IntStream.generate(() -> i)
//                .limit(i))
//        .forEach(System.out::println);


//        IntStream.range(0, 10)
//                .boxed()
//                .collect(Collectors.partitioningBy(i->i%2==0))
//                .entrySet().forEach(System.out::println);

//        IntStream.range(-5, 0)
//                .flatMap(i -> IntStream.of(i,-i))
//                .boxed()
//                .sorted(Comparator.comparing(Math::abs))
//                .forEach(System.out::println);

//        IntStream.range(1, 5)
//                .flatMap(i -> IntStream.generate(() -> i).limit(i))
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().forEach(System.out::println);


//            List<Integer> numbers = Arrays.asList(1, 3, 5, 7);
//            numbers.stream()
//                .map(i->i*2)
//                .forEach(System.out::println);

//        List<String> names = Arrays.asList("john", "arya", "sansa");
//        names.stream()
//                .map(StringUtils::capitalize)
////              .map(ch -> ch.toUpperCase())
//                .forEach(System.out::println);


//        List<Car> cars = Arrays.asList(
//                new Car("AA1111BX", 2007),
//                new Car("AM1111BE", 2009),
//                new Car("AK5555IT", 2010),
//                new Car("AI5601CC", 2015),
//                new Car("AI3838PP", 2017));
//
//        cars.stream()
//                .filter(car->car.getNumber()!=null)
//                .filter(car -> car.getYear()>2010)
//                .map(Car::getNumber)
//                .forEach(System.out::println);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        List<Integer> evenNumbers = new ArrayList<>(numbers.size());
//
//        evenNumbers = numbers.stream()
//                .filter(i -> i%2==0)
//                .collect(Collectors.toList());
//
//        System.out.println(evenNumbers); //output [2, 4, 6, 8, 10]


//        List<String> names = Arrays.asList("John", "Arya", "Sansa");
//        Set<String> upperCaseNames = new HashSet<>();
//        upperCaseNames =
//                names.stream()
//                .map(String::toUpperCase)
//                .collect(Collectors.toSet());
//        System.out.println(upperCaseNames); //output [ARYA, JOHN, SANSA]


//        List<String> names = Arrays.asList("Jaime", "Daenerys", "", "Tyrion", "");
//        Queue<String> queue =
//                names.stream()
//                .filter(name->!name.isEmpty())
//                .collect(Collectors.toCollection(LinkedList::new));
//
//        System.out.println(queue); //output [Jaime, Daenerys, Tyrion]


//        List <Integer> list = IntStream.range(1, 101).boxed().collect(Collectors.toList());

        List list =
                Stream.iterate(1, i -> i + 1)
                        .limit(3)
                        .collect(Collectors.toCollection(ArrayList::new));

        int sum = list.stream()
                .mapToInt(e-> (int) e)
                .reduce(0, (acc,element)->acc+element);
        System.out.println(sum);
//        list.add(50);
//        int sumArr = list.stream().mapToInt(e -> e).sum();
//        int result = sumArr - sum;
//        System.out.println(result);

//        Map<Character, Long> h = Stream.of('a','a','b', 'b', 'b', 'c')
//                .collect(Collectors.groupingBy(
//                        Function.identity(), Collectors.counting()));
//
//        h.entrySet().stream()
//                .forEach(System.out::println);


//        List<String> wordList = Arrays.asList(
//                "every", "problem", "in", "computer", "science",
//                "can", "be", "solved", "by", "adding", "another",
//                "level", "of", "indirection");
        // Butler Lampson

//        wordList.stream()
//                .forEach(System.out::println);

//        List<String> output = wordList.stream()
//                .map(String::toUpperCase)
//                .collect(toList());
//        output.forEach(System.out::println);

//        List<String> output = wordList.stream()
//                .filter(e->e.length()%2==0)
//                .collect(toList());
//        output.forEach(System.out::println);

        setUpBufferedReader();
//        long count = reader.lines()
//                .count();
//        System.out.println(count);


//        String output =
//                reader.lines()
//                .limit(4)
//                .skip(2)
//                .map(e->e.concat(e))
//                .forEach(System.out::println);

//        int longest =
//                reader.lines()
//                        .mapToInt(String::length)
//                        .max()
//                        .getAsInt();
//        System.out.println(longest);

//        List<String> output =
//        reader.lines()
//                .flatMap(line->Stream.of(line.split(REGEXP)))
//                .filter(e->e.length()>0)
//                .map(String::toLowerCase)
//                .sorted()
//                .collect(toList());
//        output.forEach(System.out::println);

//        List<String> output =
//                reader.lines()
//                        .flatMap(line->Stream.of(line.split(REGEXP)))
//                        .filter(e->e.length()>0)
//                        .map(String::toLowerCase)
//                        .distinct()
////                        .sorted(comparingInt(String::length)
////                                .thenComparing(naturalOrder()))
//                        .sorted(comparingInt(String::length).thenComparing(naturalOrder()))
//                        .collect(toList());
//        output.forEach(System.out::println);


//        Map<Integer, List<String>> map =
//                reader.lines()
//                        .flatMap(line->Stream.of(line.split(REGEXP)))
//                        .filter(e->e.length()>0)
//                        .map(String::toLowerCase)
//                        .collect(groupingBy(String::length));
//        map.entrySet().forEach(System.out::println);

//        Map<String, Long> map =
//                reader.lines()
//                        .flatMap(line->Stream.of(line.split(REGEXP)))
//                        .filter(e->e.length()>0)
//                        .map(String::toLowerCase)
//                        .collect(groupingBy(Function.identity(),counting()));
//        map.entrySet().forEach(System.out::println);


//        Map<String, Map<Integer, List<String>>> map =
//                reader.lines()
//                        .flatMap(line->Stream.of(line.split(REGEXP)))
//                        .filter(e->e.length()>0)
//                        .collect(groupingBy(e->e.substring(0,1),groupingBy(String::length))
//                        );
//
//        map.entrySet().forEach(System.out::println);
//
//        closeBufferedReader();



    }


    public static void main(String[] args) throws IOException {
        NewEx newEx = new NewEx(reader);

        zzz();

    }

    final static String REGEXP = "\\W+"; // for splitting into words


    static BufferedReader reader;


    public static void setUpBufferedReader() throws IOException {
        reader = Files.newBufferedReader(Paths.get("C:\\Users\\Ruslan_Omelchenko\\IdeaProjects\\java-8-lambdas-exercises\\src\\main\\java\\SonnetI.txt"), StandardCharsets.UTF_8);
    }

    public static void closeBufferedReader() throws IOException {
        reader.close();
    }

}
