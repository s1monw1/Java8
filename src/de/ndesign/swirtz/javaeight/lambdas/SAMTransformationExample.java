package de.ndesign.swirtz.javaeight.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * author: Simon
 * created on 18.01.2016.
 */
public class SAMTransformationExample {

    public static void main(String[] args) {

        //Diamond nicht möglich für Anonyme Innere Klasse
        Comparator<String> compareByLength = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                final int l1 = o1.length();
                final int l2 = o2.length();

                if (l1 < l2) return -1;
                if (l1 > l2) return 1;
                return 0;

                //Seit JDK 7:
                //return Integer.compare(o1.length(), o2.length());
            }
        };

        Comparator<String> compareByLengthLambda2 = (final String o1, final String o2) -> {
            return Integer.compare(o1.length(), o2.length());
        };

        //Type Inference und Kurzschreibweise
        Comparator<String> compareByLengthLambda = (o1, o2) -> Integer.compare(o1.length(), o2.length());

        //Lambdas als Parameter und Rückgabewert
        final List<String> names = Arrays.asList("Uwe", "Christoph", "Daniela", "Mandy");
        Collections.sort(names, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println(names);
        //Lamdba als Rückgabe von Methode, List sort-Methode, Methoden wie reversed() ab 1.8
        names.sort(getStringComparator().reversed());
        System.out.println(names);
    }

    private static Comparator<String> getStringComparator() {
        return (o1, o2) -> Integer.compare(o1.length(), o2.length());
    }
}
