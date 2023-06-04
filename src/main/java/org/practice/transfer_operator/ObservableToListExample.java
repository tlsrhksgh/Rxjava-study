package org.practice.transfer_operator;

import io.reactivex.Observable;
import io.reactivex.Single;
import org.practice.common.SampleData;

import java.util.List;

public class ObservableToListExample {
    public static void main(String[] args) {
        // 1번 예제
        Single<List<Integer>> single = Observable.just(1, 3, 5, 7, 9)
                .toList();

        single.subscribe(System.out::println);

        // 2번 예제
        Observable.fromIterable(SampleData.carList)
                .toList()
                .subscribe(System.out::println);
    }
}
