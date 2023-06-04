package org.practice.transfer_operator;

import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Map;

/**
 * 발행한 데이터에서 map의 키를 생성한 후, 각각의 키별로 원본 데이터를 매핑해서 Map으로 반환하는 예제
 */
public class ObservableToMapExample {
    public static void main(String[] args) {
        Single<Map<String, String>> single =
                Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
                        .toMap(data -> data.split("-")[0]);

        single.subscribe(System.out::println);

        Single<Map<String, String>> map =
                Observable.just("a-Alpha", "b-Bravo", "c-Charlie", "e-Echo")
                        .toMap(
                                data -> data.split("-")[0],
                                data -> data.split("-")[1]
                        );

        map.subscribe(System.out::println);
    }
}
