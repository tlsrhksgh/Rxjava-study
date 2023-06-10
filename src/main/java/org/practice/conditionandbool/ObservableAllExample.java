package org.practice.conditionandbool;

import io.reactivex.Observable;
import org.practice.common.Car;
import org.practice.common.CarMaker;
import org.practice.common.SampleData;

/**
 * all을 사용하여 발행된 데이터 전체가 파라미터로 입력된 조건과 일치하는지 판단하는 예제
 * 2번 째 데이터부터는 조건과 일치하지 않기 때문에 구독 해지가된 후 소비자에게 false를 반환
 */
public class ObservableAllExample {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .doOnNext(car -> System.out.println("Car Maker: " + car.getCarMaker() +
                        "\tCar name: " + car.getCarName()))
                .map(Car::getCarMaker)
                .all(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
                .subscribe(System.out::println);

    }
}
