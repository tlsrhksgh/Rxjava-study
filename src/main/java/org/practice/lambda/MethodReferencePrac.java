package org.practice.lambda;

import io.reactivex.functions.BiPredicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferencePrac {
    public static void main(String[] args) throws Exception {
        // 축약 전
        Function<Integer, String> f1 = i -> String.valueOf(i);
        String num1 = f1.apply(1);
        System.out.println(num1);

        BiPredicate<List<Integer>, Integer> bp1 = (list, num) -> list.contains(num);

        // 축약 후
        Function<Integer, String> f2 = String::valueOf;
        String num2 = f2.apply(3);
        System.out.println(num2);

        Consumer<String> c =System.out::println;
        c.accept("hello");
        System.out.println(c);

        BiPredicate<List<Integer>, Integer> bp2 = List::contains;
        System.out.println(bp2.test(Arrays.asList(1, 3, 5, 7, 9), 11));
    }
}
