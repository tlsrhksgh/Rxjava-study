package org.practice.utility;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;

/**
 * Material/Dematerial 연산자의 실제 활용 예제
 * - 특정 Observable 에서 에러가 발생 할 경우 해당 에러에 대해서 구체적으로 처리할 수 있다.
 */

public class MaterialExample02 {
    public static void main(String[] args) throws InterruptedException {
        Observable.concatEager(
                Observable.just(
                        getDbUser().subscribeOn(Schedulers.io()),
                        getAPIUser()
                                .subscribeOn(Schedulers.io())
                                .materialize()
                                .map(notification -> {
                                    if (notification.isOnError()) {
                                        // 관리자에게 에러 발생을 알림
                                        System.out.println("# API user 에러 발생!");
                                    }
                                    return notification;
                                })
                                .filter(notification -> !notification.isOnError())
                                .dematerialize(notification -> notification)
                )
        ).subscribe(
                System.out::println,
                System.out::println,
                () -> System.out.println("Complete!!")
        );

        Thread.sleep(1000L);
    }

    private static Observable<String> getDbUser() {
        return Observable.fromIterable(Arrays.asList("DB user1", "DB user2", "DB user3", "DB user4", "DB user5"));
    }

    private static Observable<String> getAPIUser() {
        return Observable
                .just("API user1", "API user2", "Not User", "API user4", "API user5")
                .map(user -> {
                    if(user.equals("Not User"))
                        throw new RuntimeException();
                    return user;
                });
    }
}
