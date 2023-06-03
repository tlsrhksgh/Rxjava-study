package org.practice.lambda;

import java.util.function.Function;

public class ClassNameStaticMethodExample {
    public static void main(String[] args) {
        // 람다 표현식 메서드 레퍼런스로 축약 전
        Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);
        Integer result1 = f1.apply("3");
        System.out.println(result1);

        Function<String, Integer> f2 = (String s) -> Integer.parseInt(s);
        Integer result2 = f1.apply("3");
        System.out.println(result2);

        // 메서드 레퍼런스로 축약
        Function<String, Integer> f3 = Integer::parseInt;
        Integer result3 = f3.apply("3");
        System.out.println(result3);
    }
}
