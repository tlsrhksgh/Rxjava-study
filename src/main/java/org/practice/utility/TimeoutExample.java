package org.practice.utility;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * 각 데이터 발행 시, 지정한 시간안에 데이터가 발행되지 않으면 Timeout Exception 발생
 * 네트워크 연결 지연 등으로 인한 처리를 위해 사용하기 좋은 연산자.
 */
public class TimeoutExample {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .map(num -> {
                    long time = 1000L;
                    if(num == 4) {
                        time = 1500L;
                    }
                    Thread.sleep(time);
                    return num;
                })
                .timeout(1499L, TimeUnit.MILLISECONDS)
                .subscribe(
                        System.out::println,
                        System.out::println
                );
    }
}
