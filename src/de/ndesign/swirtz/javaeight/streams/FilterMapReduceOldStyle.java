package de.ndesign.swirtz.javaeight.streams;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.time.Month.*;

/**
 * @author: Simon
 * created on 29.02.2016.
 */
public class FilterMapReduceOldStyle {
    private static final List<Person> persons = Arrays.asList(
            new Person("Stefan", LocalDate.of(1971, MAY, 12)),
            new Person("Micha", LocalDate.of(1971, FEBRUARY, 7)),
            new Person("Andi Bubolz", LocalDate.of(1968, JULY, 17)),
            new Person("Andi Steffens", LocalDate.of(1970, JULY, 22)),
            new Person("Merten", LocalDate.of(1975, JUNE, 16))
    );

    public static void main(String[] args) {
        //Schritt 1
        final List<Person> bornInJuly = filterByMonth(persons, JULY);
        //Schritt 2
        final List<String> names = extractNameAttribute(bornInJuly);
        //Schritt 3
        final String result = joinStrings(names, ", ");

        System.out.println(result);
        //Nachteile: sequentielle Abarbeitung, Laufzeit steigt linear zu Anzahl der Personen

    }

    private static List<Person> filterByMonth(List<Person> persons, Month month) {
        final List<Person> filtered = new ArrayList<>();
        for (Person p : persons) {
            if (p.getBirthDate().getMonth().equals(month)) {
                filtered.add(p);
            }
        }
        return filtered;
    }

    private static List<String> extractNameAttribute(List<Person> bornInJuly) {
        final List<String> names = new ArrayList<>();
        for (Person p : bornInJuly) {
            names.add(p.getName());
        }
        return names;
    }

    private static String joinStrings(List<String> names, final String delimiter) {
        final StringBuilder sb = new StringBuilder();
        final Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(delimiter);
        }
        return sb.toString();
    }
}
