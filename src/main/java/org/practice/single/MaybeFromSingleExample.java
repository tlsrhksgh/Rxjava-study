package org.practice.single;

import io.reactivex.Maybe;
import io.reactivex.Single;

import java.util.Date;

public class MaybeFromSingleExample {
    public static void main(String[] args) {
        Single<String> single = Single.just(new Date().toString());
        Maybe.fromSingle(single)
                .subscribe(
                        data -> System.out.println("onSuccess: " + data),
                        error -> System.out.println("onError: " + error),
                        () -> System.out.println("Complete!!"));

    }
}
