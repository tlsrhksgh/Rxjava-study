package org.practice.transfer_operator;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;


/**
 * Concatmap은 순서를 보장해주는 대신 처리 속도가 느리지만
 * Flatmap은 순서를 보장하진 않지만 처리 속도가 concatmap보다 빠르다
  */
public class ConcatMapvsFlatMapExample {
    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .flatMap(
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

        Thread.sleep(4000L);
    }
}
