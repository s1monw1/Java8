package de.ndesign.swirtz.javaeight.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: Simon
 * created on 20.01.2016.
 */
public class MethodReferences {

    public static void main(String[] args) {
        final List<String> names = Arrays.asList("Uwe", "Christoph", "Daniela", "Mandy");
        Collections.sort(names, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        //Methodenreferenz
//        List<String> filtered = filter(n -> isGreater3(n), names);
        List<String> filtered = filter(MethodReferences::isGreater3, names);
        filtered.forEach(System.out::println);

    }

    private static boolean isGreater3(String n) {
        return n.length() > 3;
    }

    private static <T> List<T> filter(Predicate<T> predicate, List<T> source) {
        List<T> dest = new ArrayList<>();
        for (T item : source) {
            if (predicate.test(item)) {
                dest.add(item);
            }
        }
        return dest;
    }
}
