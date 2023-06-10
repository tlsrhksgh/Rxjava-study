package org.practice.conditionandbool;

import io.reactivex.Observable;
import org.practice.common.CarMaker;
import org.practice.common.SampleData;

/**
 * 발행된 데이터 중 파라미터로 입력한 조건에 맞는 데이터가 있는지 판단하는 예제
 * 일치하는 데이터가 발행되면 true를 반환
 */
public class ObservableContainsExample {
    public static void main(String[] args) {
        Observable.fromArray(SampleData.carMakersDuplicated)
                .doOnNext(System.out::println)
                .contains(CarMaker.KIA)
                .subscribe(System.out::println);
    }
}
