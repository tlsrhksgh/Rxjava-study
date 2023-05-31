package org.practice;

import io.reactivex.Flowable;

public class ColdPublisherExample {
    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.just(1, 3, 5, 7);

        // 새로운 타임라인이 생성되며 구독되는 시점부터 첫번째 데이터가 순차적으로 다시 발행된다.
        flowable.subscribe(data -> System.out.println("구독자1: " + data));
        flowable.subscribe(data -> System.out.println("구독자2: " + data));
    }
}
