package org.practice.backpressure;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackPressureErrorExample {
    public static void main(String[] args) throws InterruptedException{
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .doOnNext(System.out::println)
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            System.out.println("# 소비자 처리 대기 중..");
                            Thread.sleep(1000L);
                        },
                        System.out::println,
                        () -> System.out.println("Hello")
                );

        Thread.sleep(2000L);
    }
}
