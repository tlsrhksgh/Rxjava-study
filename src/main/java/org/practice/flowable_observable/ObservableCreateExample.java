package org.practice.flowable_observable;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObservableCreateExample {
    public static void main(String[] args) throws InterruptedException{
        Observable<String> observable =
                Observable.create(emitter -> {
                    String[] datas = {"Hello", "RxJava"};

                    for(String data : datas) {
                        if(emitter.isDisposed()) {
                            return;
                        }

                        emitter.onNext(data);
                    }
                    emitter.onComplete();
                });

        observable.observeOn(Schedulers.computation())
                .subscribe(data -> System.out.println("OnNext(): " + data),
                        error -> System.out.println("Error: " + error),
                        () -> System.out.println("Complete!!"),
                        disposable -> System.out.println("데이터를 받을 준비 완료!"));

        Thread.sleep(1000L);
    }
}
