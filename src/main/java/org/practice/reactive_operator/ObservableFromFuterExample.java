package org.practice.reactive_operator;

import io.reactivex.Observable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ObservableFromFuterExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Start time:" + start);

        // 긴 처리 시간이 걸리는 작업
        Future<Double> future = longTimeWork();

        // 짧은 처리 시간이 걸리는 작업
        shortTimeWork();

        Observable.fromFuture(future)
                .subscribe(data -> System.out.println("긴 처리 시간 작업 결과 : " + data));

        long end = System.currentTimeMillis();
        System.out.println("실행 시간: " + (end - start));
    }

    private static Future<Double> longTimeWork() {
        return CompletableFuture.supplyAsync(() -> calculate());
    }

    private static Double calculate() {
        System.out.println("긴 처리 시간이 걸리는 작업 중....");
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100000000000.0;
    }

    private static void shortTimeWork() {
        try {
            Thread.sleep(6300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("짧은 처리 시간 작업 완료!");
    }
}
