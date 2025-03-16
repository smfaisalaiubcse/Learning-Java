package LemdaExpression;

import java.util.function.Function;

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
        System.out.println(mul.apply(10));
    }
}
