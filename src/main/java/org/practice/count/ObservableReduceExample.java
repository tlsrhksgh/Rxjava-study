package org.practice.count;

import io.reactivex.Observable;

public class ObservableReduceExample {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .doOnNext(System.out::println)
                .reduce((x, y) -> x + y)
                .subscribe(System.out::println);
    }
}
