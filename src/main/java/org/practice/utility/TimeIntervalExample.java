package org.practice.utility;

import io.reactivex.Observable;

import java.util.Random;

/**
 * timeInterval을 이용해서 데이터 발행이 소요된 시간과 데이터를 같이 발행하는 예제
 */
public class TimeIntervalExample {
    public static void main(String[] args) {
        Observable.just(1, 3, 5, 7, 9)
                .delay(item -> {
                    Thread.sleep((int)(Math.random() * (1000 - 100 + 1)) + 100);
                    return Observable.just(item);
                })
                .timeInterval()
                .subscribe(time -> System.out.println("발행되는데 걸린 시간: " + time.time() + "\t# 발행된 데이터: " +time.value()));
    }
}
