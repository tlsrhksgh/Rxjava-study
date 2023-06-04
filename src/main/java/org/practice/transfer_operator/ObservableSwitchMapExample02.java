package org.practice.transfer_operator;

import io.reactivex.Observable;
import org.practice.common.Searcher;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableSwitchMapExample02 {
    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();
        Searcher searcher = new Searcher();

        List<String> keywords = Arrays.asList("M", "Ma", "Mal", "Malay");

        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .concatMap(data -> { // concatMap을 사용했기 때문에 매번 모든 키워드 검색 결과를 다 가져온다.
                    String keyword = keywords.get(data.intValue()); // 데이터베이스에서 조회한다고 가정

                    return Observable.just(searcher.search(keyword))
                            .doOnNext(notUse -> System.out.println("======================================="))
                            .delay(1000L, TimeUnit.MILLISECONDS);
                })
                .flatMap(resultList -> Observable.fromIterable(resultList))
                .subscribe(
                        data -> System.out.println("onNext: " + data),
                        error -> System.out.println(error),
                        () -> {
                            long end = System.currentTimeMillis();
                            System.out.println("실행 시간: " + (end - start) + "ms");
                        }
                );

        Thread.sleep(6000L);
    }
}
