package org.practice.conditionandbool;

import io.reactivex.Observable;

/**
 * filter 조건에 부합하는 데이터가 없는 경우 default값을 반환
 */
public class ObservableDefaultIfEmptyExample {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .filter(num -> num > 5)
                .defaultIfEmpty(10)
                .subscribe(System.out::println);
    }
}
