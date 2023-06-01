package org.practice.single;

import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

/**
 * 데이터 생산자이지만 데이터를 1건도 발행하지 않고 완료 또는 에러를 발행
 * 데이터 발행 역할 대신에 Completable내에서 특정 작업을 수행한 후 작업 처리가 끝났음을 알려주는 역할.
 * Completable의 대표적 소비자는 CompletableObserver
 */
public class CompletableExample {
    public static void main(String[] args) throws InterruptedException{
        Completable completable = Completable.create(emitter -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            System.out.println("sum의 결과: " + sum);

            emitter.onComplete();
        });

        completable.subscribeOn(Schedulers.computation())
                .subscribe(
                        () -> System.out.println("Complete!!"),
                        error -> System.out.println("onError: " + error));

        Thread.sleep(100L);
    }
}
