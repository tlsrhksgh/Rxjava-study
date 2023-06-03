package org.practice.transfer_operator;

import io.reactivex.Observable;

// flatmap을 이용한 구구단
public class ObservableFlatMapExample02 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Observable.range(2, 1)
                .flatMap(num -> Observable.range(1, 100000)
                        .map(row -> num + " * " + row + " = " + num * row))
                .subscribe(System.out::println);

        long end = System.currentTimeMillis();
        System.out.println("실행시간 : " + (end - start) + "ms");
    }
 }
