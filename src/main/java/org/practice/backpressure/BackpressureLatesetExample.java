package org.practice.backpressure;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackpressureLatesetExample {
    public static void main(String[] args) throws InterruptedException{
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println("#interval doOnNext()" + data))
                .onBackpressureLatest()
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(
                        data -> {
                            Thread.sleep(1000L);
                            System.out.println("onNext(): " + data);
                        },
                        error -> System.out.println("Error: " + error));

        Thread.sleep(7000L);
    }
}
