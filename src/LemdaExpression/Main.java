package LemdaExpression;

import java.util.ConcurrentModificationException;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Notification n = () -> System.out.println("Test successfull");
        n.test();
        //Anonymous function
        Function<Integer, Integer> multiply = new Function<Integer, Integer>() {
                @Override
                public Integer apply(Integer num1) {
                    return num1 * num1;
                }
        };
        System.out.println(multiply.apply(20));

        //same thing with the help of lemda expression with shorter syntax
        Function<Integer, Integer> mul = (Integer num1) -> num1 * num1; //Apply function er body eita -- anonymous function
        Function<Integer, Integer> add = (Integer num1) -> num1 + 50;
        mul.apply(10);
        System.out.println("Output: " + mul.andThen(add).apply(10));

        //Do it by bifunction hw

        Consumer<String> consumer = (String val) -> System.out.println(val);
        consumer.accept("My message");

        Supplier<Integer> supplier = () -> new Random().nextInt(100);
        //baki gula pic phone e

    }
}
