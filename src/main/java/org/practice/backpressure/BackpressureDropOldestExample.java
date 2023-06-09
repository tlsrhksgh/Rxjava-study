package org.practice.backpressure;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackpressureDropOldestExample {
    public static void main(String[] args) throws InterruptedException{
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println("#Interval doOnNext(): " + data))
                .onBackpressureBuffer(
                        2,
                        () -> System.out.println("overflow!"),
                        BackpressureOverflowStrategy.DROP_OLDEST)
                .doOnNext(data -> System.out.println("#onBackpressureBuffer doOnNext(): " + data))
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            Thread.sleep(1000L);
                            System.out.println("I`m Subscribe: " + data);
                        },
                        System.out::println);

        Thread.sleep(4000L);
    }
}
