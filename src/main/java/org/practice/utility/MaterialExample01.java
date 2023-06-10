package org.practice.utility;

import io.reactivex.Observable;

/**
 * Material은 Notification이라는 객체를 반환하고 해당 객체는 데이터의 타입과 value를
 * 같이 반환해주고 데이터 발행이 완료되면 onComplete를 호출하게 된다.
 */
public class MaterialExample01 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6)
                .materialize()
                .subscribe(notification -> {
                    String notificationType =
                            notification.isOnNext() ? "onNext()" : notification.isOnError() ? "onError()" : "onComplete()";
                    System.out.println("notification 타입: " + notificationType + ", value: " + notification.getValue());
                });
    }
}
