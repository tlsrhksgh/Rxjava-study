package org.practice.transfer_operator;

import io.reactivex.Observable;

/**
 * FlatMap 두 번째 유형을 이용한 구구단의 2단 출력 예제
 */
public class ObservableFlatMapExample03 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Observable.range(2, 1)
                .flatMap(
                        data -> Observable.range(1, 100000),
                        (sourceData, transformedData) ->
                                sourceData + " * " + transformedData + " = " + sourceData * transformedData)
                .subscribe(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println("실행시간 : " + (end - start) + "ms");
    }
}
