package org.practice.transfer_operator;

import io.reactivex.Observable;
import org.practice.common.Searcher;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableSwitchMapExample03 {
    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();
        Searcher searcher = new Searcher();

        List<String> keywords = Arrays.asList("M", "Ma", "Mal", "Malay");

        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .doOnNext(data -> System.out.println("doOnNext(): " + data))
                .switchMap(data -> {
                    String keyword = keywords.get(data.intValue());

                    return Observable.just(searcher.search(keyword))
                            .delay(1000L, TimeUnit.MILLISECONDS);
                })
                .flatMap(resultList -> Observable.fromIterable(resultList))
                .subscribe(
                        data -> System.out.println("onNext(): " + data),
                        error -> System.out.println(error),
                        () -> {
                             long end = System.currentTimeMillis();
                            System.out.println("실행시간: " + (end - start) + "ms");
                        }
                );

        Thread.sleep(3000L);
    }
}
