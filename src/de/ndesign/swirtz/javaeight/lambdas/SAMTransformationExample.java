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
            public int compare(final String o1, final String o2) {
                final int len1 = o1.length();
                final int len2 = o2.length();

                if (len1 < len2) return -1;
                if (len1 > len2) return 1;
                return 0;

                //Seit JDK 7:
                //return Integer.compare(o1.length(), o2.length());
            }
        };


        Comparator<String> compareByLengthLambda = (final String o1, final String o2) -> {
            return Integer.compare(o1.length(), o2.length());
        };

    }

}
