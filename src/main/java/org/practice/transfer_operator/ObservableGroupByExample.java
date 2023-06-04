package org.practice.transfer_operator;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;
import org.practice.common.Car;
import org.practice.common.CarMaker;
import org.practice.common.SampleData;

/**
 * 제조사 별로 그룹을 묶어 데이터를 출력하는 예제
 */
public class ObservableGroupByExample {
    public static void main(String[] args) {
        Observable<GroupedObservable<CarMaker, Car>> observable =
                Observable.fromIterable(SampleData.carList)
                        .groupBy(Car::getCarMaker);

        observable.subscribe(
                groupedObservable -> groupedObservable.subscribe(
                        car -> System.out.println("onNext(): Group: " +
                                groupedObservable.getKey() +
                                "\t Car name: " + car.getCarName())
                )
        );
    }
}
