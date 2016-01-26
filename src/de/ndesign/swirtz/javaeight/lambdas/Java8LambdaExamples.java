package de.ndesign.swirtz.javaeight.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: Simon
 * created on 20.01.2016.
 */
public class Java8LambdaExamples {

    public static void main(String[] args) {
        //Type Inference und Kurzschreibweise
        Comparator<String> compareByLengthLambda = (o1, o2) -> Integer.compare(o1.length(), o2.length());

        //Lambdas als Parameter und Rückgabewert
        final List<String> names = Arrays.asList("Uwe", "Christoph", "Daniela", "Mandy");
        Collections.sort(names, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println(names);
        //Lamdba als Rückgabe von Methode, List sort-Methode, Methoden wie reversed() ab 1.8
        names.sort(getStringComparator().reversed());
        System.out.println(names);

        //Default-Methoden im Einsatz
        Consumer<String> stringConsumer = n -> System.out.println("Länge von " + n + ": " + n.length());
        names.forEach(stringConsumer.andThen(n -> System.out.println("Aufruf default-Methode aus Consumer")));

    }

    private static Comparator<String> getStringComparator() {
        return (o1, o2) -> Integer.compare(o1.length(), o2.length());
    }
}
