package org.practice.single;

import io.reactivex.Single;

import java.util.Date;

public class SingleJustExample {
    public static void main(String[] args) {
        Single.just(new Date().toString())
                .subscribe(
                        data -> System.out.println("onSuccess 호출: " + data),
                        error -> System.out.println("onError: " + error));

    }
}
