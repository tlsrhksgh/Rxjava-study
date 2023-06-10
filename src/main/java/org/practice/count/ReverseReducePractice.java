package org.practice.count;

import io.reactivex.Observable;

/**
 * 10 부터 1 까지 역순으로 빼기 연산을 하는 예제
 * answer: -35
 */
public class ReverseReducePractice {
    public static void main(String[] args) {
        Observable.range(1, 9)
                .reduce(10, (x, y) -> {
                    int minus = 10 - y;
                    return x - minus;
                })
                .subscribe(System.out::println);
    }
}
