package org.practice.lambda;

import org.practice.common.Car;

import java.util.function.Function;

/**
 * Class Name::instance method 메서드 레퍼런스
 */
public class ObjectInstanceMethodExample {
    public static void main(String[] args) {
        Function<Car, String> f1 = car -> car.getCarName();
        String carName1 = f1.apply(new Car("트래버스"));
        System.out.println(carName1);

        // 람다 표현식에서 파라미터로 전달받는 타입이 Car클래스의 인스턴스이기 때문에 추론이 가능하여 메서드레퍼런스로 축약 가능.
        Function<Car, String> f2 = Car::getCarName;
        String carName2 = f2.apply(new Car("펠리세이드"));
        System.out.println(carName2);
    }
}
