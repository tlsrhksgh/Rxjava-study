package org.practice.reactive_operator;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ObservableFromIterableExample {
    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Korea", "Japan", "China", "Canada", "Italy");

        Observable.fromIterable(countries)
                .subscribe(c -> System.out.println("OnNext(): " + c));
    }
}
