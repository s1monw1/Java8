package de.ndesign.swirtz.javaeight.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Simon
 * created on 28.02.2016.
 */
public class IntermediateOperationsExample {

    public static void main(String[] args) throws IOException {
        final Path exampleFile = Paths.get("res/stream_example.txt");
        final List<String> contents = Files.readAllLines(exampleFile);
        System.out.println(contents);

        //Streamerzeugung
        Stream<String> words = contents.stream();
        words = words.flatMap(l -> Stream.of(l.split(" ")));
//        words.forEach(System.out::println);

        //Prädikate für zu kurze Wörter
        Predicate<String> isShortWord = s -> s.length() < 4;
        Predicate<String> notShortWord = isShortWord.negate();

        //Prädikate für spezielle und zu ignorierende Wörter
        List<String> ignorableWords = Arrays.asList("this", "these", "them");
        Predicate<String> isIgnorableWord = word ->
                ignorableWords.contains(word.toLowerCase());
        Predicate<String> isSignificantWord = isIgnorableWord.negate();

        //Filterung basierend auf Prädikaten
        Stream<String> filteredWords = words.
                map(String::trim).
                filter(notShortWord).
                filter(isSignificantWord);

        final Function<String, String> removePunctuationMarks = s -> {
            if (s.endsWith(".") || s.endsWith(":") || s.endsWith("!")) {
                return s.substring(0, s.length() - 1);
            }
            return s;
        };
        final Stream<String> mapped = filteredWords.map(removePunctuationMarks);
        final Stream<String> sorted = mapped.sorted(String.CASE_INSENSITIVE_ORDER);
//        sorted.forEach(it -> System.out.print(it + ", "));

        //Fortsetzung

        //Gruppierung
        Function<String, String> identity = Function.identity();
        Map<String, Long> grouped = sorted.
                collect(Collectors.groupingBy(identity, Collectors.counting()));
        //Sortierung der schlüssel anhand TreeMap<K,V>
        Map<String, Long> sortedResult = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedResult.putAll(grouped);
        System.out.println(sortedResult);
    }
}
