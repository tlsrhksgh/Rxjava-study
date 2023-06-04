package org.practice.transfer_operator;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;
import org.practice.common.Car;
import org.practice.common.CarMaker;
import org.practice.common.SampleData;

/**
 * Group으로 묶은 데이터들 중 filter를 이용해 필터링한 Group의 데이터만 출력하는 예제
 */
public class ObservableGroupedByExample02 {
    public static void main(String[] args) {
        Observable<GroupedObservable<CarMaker, Car>> observable =
                Observable.fromIterable(SampleData.carList)
                        .groupBy(Car::getCarMaker);

        observable.subscribe(
                groupedObservable ->
                        groupedObservable
                                .filter(car -> groupedObservable.getKey().equals(CarMaker.CHEVROLET))
                                .subscribe(
                                        car -> System.out.println("onNext(): Group: " +
                                                groupedObservable.getKey() +
                                                "\t Car name: " + car.getCarName())
                                )
        );
    }
}
