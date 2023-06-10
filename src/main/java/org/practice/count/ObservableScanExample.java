package org.practice.count;

import io.reactivex.Observable;

/**
 * reduce는 최종 결과만 반환하는 반면 scan은 연산마다 결과 값을 반환한다.
 */
public class ObservableScanExample {
    public static void main(String[] args) {
        Observable.just("a", "b", "c", "d", "e")
                .scan((x, y) -> "(" + x + ", " + y + ")")
                .subscribe(System.out::println);

    }
}
