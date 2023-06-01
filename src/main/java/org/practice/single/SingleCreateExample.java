package org.practice.single;

import io.reactivex.Single;

import java.util.Date;

/**
 * 데이터를 1건만 발행하거나 에러를 발행함. 그러므로 데이터 개수를 요청할 필요 X
 * single은 데이터를 1건만 발행하기 때문에 발행했다는 자체가 완료를 의미하므로 onComplete는 하지 않음.
 * onNext(), onComplete() 기능은 없고 이 둘을 합한 onSuccess()를 제공
 * Webflux에서 Mono와 같은 기능.
 * Single의 대표적 소비자는 SingleObservable
 * Client 서버 구조에서 클라이언트 요청에 대응하는 서버의 응답이 single을 사용하기 좋다.
 */
public class SingleCreateExample {
    public static void main(String[] args) {
        Single<String> single = Single.create(emitter -> emitter.onSuccess(new Date().toString()));

        single.subscribe(
                data -> System.out.println("onSuccess 호출: " + data),
                error -> System.out.println("Error:" + error));
    }
}
