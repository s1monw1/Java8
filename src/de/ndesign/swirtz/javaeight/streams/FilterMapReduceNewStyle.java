package de.ndesign.swirtz.javaeight.streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.Month.*;

/**
 * @author: Simon
 * created on 29.02.2016.
 */
public class FilterMapReduceNewStyle {

    private static final List<Person> persons = Arrays.asList(
            new Person("Stefan", LocalDate.of(1971, MAY, 12)),
            new Person("Micha", LocalDate.of(1971, FEBRUARY, 7)),
            new Person("Andi Bubolz", LocalDate.of(1968, JULY, 17)),
            new Person("Andi Steffens", LocalDate.of(1970, JULY, 22)),
            new Person("Merten", LocalDate.of(1975, JUNE, 16))
    );

    public static void main(String[] args) {

        String reduced = persons.stream().
                filter(person -> person.getBirthDate().getMonth().equals(JULY)).
                map(Person::getName).
                collect(Collectors.joining(", "));
//              reduce("", stringCombiner);
        System.out.println(reduced);
    }

//        BinaryOperator<String> stringCombiner = (s1, s2) -> {
//            if (s1.isEmpty()) {
//                return s2;
//            }
//            return s1 + ", " + s2;
//        };
}
