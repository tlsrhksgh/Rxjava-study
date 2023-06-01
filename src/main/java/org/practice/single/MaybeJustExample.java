package org.practice.single;

import io.reactivex.Maybe;

import java.util.Date;

public class MaybeJustExample {
    public static void main(String[] args) {
        Maybe.just(new Date().toString())
                .subscribe(data -> System.out.println("onSuccess: " + data),
                        error -> System.out.println("onError: " + error),
                        () -> System.out.println("complete!!"));

        // onComplete 호출
        Maybe.empty()
                .subscribe(data -> System.out.println("onSuccess: " + data),
                        error -> System.out.println("onError: " + error),
                        () -> System.out.println("complete!!"));
    }
}
