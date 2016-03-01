package de.ndesign.swirtz.javaeight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @author: Simon
 * created on 28.02.2016.
 */
public class IterationTypes {

    private static class Figure {
        private int size = 0;
        private int brightness = 0;

        void brighten() {
            this.brightness += 5;
        }

        void resize() {
            this.size = new Random().nextInt(50);
        }

        @Override
        public String toString() {
            return "Figure{" +
                    "size=" + size +
                    ", brightness=" + brightness +
                    '}';
        }
    }

    public static void main(String[] args) {
        //Externe Iteration
        List<Figure> figures = Arrays.asList(
                new Figure(), new Figure(), new Figure(), new Figure(), new Figure());
        brightenFigures(figures);
        for (Figure f : figures) {
            System.out.println(f);
        }

        //Interne Iteration
        process(figures, Figure::resize);
        figures.forEach(System.out::println);

    }

    private static void brightenFigures(List<Figure> values) {
        for (Figure f : values) {
            f.brighten();
        }
    }

    private static void process(List<Figure> figures, Consumer<Figure> consumer) {
        //Art der internen Iteration; Collections.removeIf(Predicate<T>) etc.
        figures.forEach(consumer);
    }

}
