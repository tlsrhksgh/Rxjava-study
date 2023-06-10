package org.practice.conditionandbool;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.practice.common.CarMaker;
import org.practice.common.SampleData;

/**
 * 발행 시점과는 무관하게 Observable의 모든 데이터(순서, 데이터 수, 데이터 타입)가 같은지 판단하는 예제
 */
public class ObservableSequenceEqualExample {
    public static void main(String[] args) {
        Observable<CarMaker> observable1 =
                Observable
                        .fromArray(SampleData.carMakers)
                        .subscribeOn(Schedulers.computation())
                        .delay(carMaker -> {
                            Thread.sleep(1000L);
                            return Observable.just(carMaker);
                        }).doOnNext(data -> System.out.println("# observable1: " + data));

        Observable<CarMaker> observable2 =
                Observable
                        .fromArray(SampleData.carMakersDuplicated)
                        .delay(carMaker -> {
                            Thread.sleep(1000L);
                            return Observable.just(carMaker);
                        }).doOnNext(data -> System.out.println("# observable2: " + data));

        Observable.sequenceEqual(observable1, observable2)
                .subscribe(System.out::println);
    }
}
