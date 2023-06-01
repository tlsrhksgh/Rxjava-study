package org.practice.single;

import io.reactivex.Maybe;

import java.util.Date;

/**
 * 데이터를 1건만 발행하거나 1건도 발행하지 않을 수 있고 에러를 발행.
 * 데이터를 1건도 발행하지 않고 처리가 종료될 경우에는 완료를 알려줌.
 * Maybe의 대표적 소비자는 MaybeObserver
 */
public class MaybeCreateExample {
    public static void main(String[] args) {
        Maybe<String> maybe = Maybe.create(emitter -> emitter.onSuccess(new Date().toString()));
//        Maybe<String> maybe = Maybe.create(MaybeEmitter::onComplete);

        maybe.subscribe(data -> System.out.println("onSuccess(): " + data),
                error -> System.out.println("onError: " + error),
                () -> System.out.println("Complete!!"));
    }
}
