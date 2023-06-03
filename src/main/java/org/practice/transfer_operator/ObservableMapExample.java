package org.practice.transfer_operator;

import io.reactivex.Observable;

public class ObservableMapExample {
    public static void main(String[] args) {
        Observable.just("korea", "america", "china", "japan", "canada")
                .filter(country -> country.length() == 5)
                .map(country -> country.toUpperCase().charAt(0) + country.substring(1))
                .subscribe(data -> System.out.println("onNext(): " + data));
    }
}
