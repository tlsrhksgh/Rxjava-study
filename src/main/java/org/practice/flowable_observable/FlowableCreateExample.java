package org.practice.flowable_observable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class FlowableCreateExample {
    public static void main(String[] args) throws InterruptedException{
        Flowable<String> flowable = Flowable.create(emitter -> {
            String[] datas = {"Hello", "RxJava"};
            for(String data : datas) {
                if(emitter.isCancelled()) {
                    return;
                }

                emitter.onNext(data);
            }

            // 데이터 발행 완료를 구독자에게 알림.
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);

        flowable.observeOn(Schedulers.computation())
                .subscribe(data -> System.out.println("OnNext(): " + data),
                        error -> System.out.println("Error: " + error),
                        () -> System.out.println("Complete!!"),
                        subscription -> subscription.request(Long.MAX_VALUE));

        Thread.sleep(1000L);
    }
}
