package org.practice.transfer_operator;

import io.reactivex.Observable;

public class ObservableFlatMapExample {
    public static void main(String[] args) {
        Observable.just("Hello")
                .flatMap(data -> Observable.just("자바", "안드로이드", "파이썬")
                        .map(lang -> data + "! " + lang))
                .subscribe(System.out::println);
    }
}
