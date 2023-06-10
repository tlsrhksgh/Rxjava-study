package org.practice.count;

import io.reactivex.Observable;

/**
 * 문자열이 누적되어 처리되는 예제
 */
public class ObservableReduceExample3 {
    public static void main(String[] args) {
        Observable.just("a", "b", "c", "d", "e")
                .reduce((x, y) -> "(" + x + "," + y + ")")
                .subscribe(System.out::println);
    }
}
