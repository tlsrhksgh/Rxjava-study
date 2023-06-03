package org.practice.transfer_operator;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableConcatMapExample01 {
    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .concatMap(
                        num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .take(10)
                                .skip(1)
                                .map(row -> num + " * " + row + " = " + num * row)
                ).subscribe(
                        System.out::println,
                        System.out::println,
                        () -> {
                            long end = System.currentTimeMillis();
                            System.out.println("실행시간: " + (end - start) + "ms");
                        }
                );

        Thread.sleep(5000L);
    }
}
