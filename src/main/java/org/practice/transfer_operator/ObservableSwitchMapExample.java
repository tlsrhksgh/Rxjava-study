package org.practice.transfer_operator;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

/**
 * 원본 소스의 처리 속도가 빨라서 현재 처리 중이던 작업을 중단하는 예제
 */

public class ObservableSwitchMapExample {
    public static void main(String[] args) throws InterruptedException{
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .doOnNext(data -> System.out.println("doOnNext(): " + data))
                .switchMap(
                        num -> Observable.interval(300L, TimeUnit.MILLISECONDS)
                                .take(10)
                                .skip(1)
                                .map(row -> num + " * " + row + " = " + num * row))
                .subscribe(data -> System.out.println("onNext(): " + data));

        Thread.sleep(5000L);
    }
}
