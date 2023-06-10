package org.practice.count;

import io.reactivex.Observable;

public class ObservableReduceExample2 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(3, (x, y) -> {
                    System.out.println("x: " + x + ", y: " + y);
                    return x + y;
                })
                .subscribe(System.out::println);
    }
}
