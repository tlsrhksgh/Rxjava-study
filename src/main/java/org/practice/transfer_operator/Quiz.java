package org.practice.transfer_operator;

import io.reactivex.Observable;

/**
 * 1. 1부터 15까지의 숫자 중 2의 배수만 필터링한 후, 필터링된 숫자에 제곱한 숫자를 출력.
 * 2. range, filter, flatmap을 이용하여 2에서 9까지의 구구단 중에서 짝수단만 출력.
 */
public class Quiz {
    public static void main(String[] args) {
        // 1번 문제
        Observable.range(1, 15)
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .subscribe(
                        data -> System.out.println("onNext: " + data),
                        System.out::println);

        // 2번 문제
        Observable.range(2, 8)
                .filter(num -> num % 2 == 0)
                .flatMap(
                        num -> Observable.range(1, 9)
                                .map(row -> num + " * " + row + " = " + num * row)
                ).subscribe(System.out::println);
    }
}
