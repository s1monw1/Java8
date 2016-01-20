package de.ndesign.swirtz.javaeight.lambdas;

import java.util.Comparator;

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

    }

}
