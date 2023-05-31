package org.practice;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackpressureDropExample {
    public static void main(String[] args) throws InterruptedException{
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println("#Interval doOnNext(): " + data))
                .onBackpressureDrop(dropData -> System.out.println(dropData + " is Drop!!"))
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            Thread.sleep(1000L);
                            System.out.println(data);
                        },
                        System.out::println
                );

        Thread.sleep(6000L);
    }
}
