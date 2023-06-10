package org.practice.conditionandbool;

import io.reactivex.Observable;
import org.practice.common.SampleData;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * amp를 이용하여 가장 먼저 발행되는 Observable을 선택하여 발행하는 예제
 */
public class ObservableAmbExample {
    public static void main(String[] args) throws InterruptedException {
        List<Observable<Integer>> observables = Arrays.asList(
                Observable.fromIterable(SampleData.salesOfBranchA)
                        .delay(200L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> System.out.println("# baranch A`s sales")),
                Observable.fromIterable(SampleData.salesOfBranchB)
                        .delay(300L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> System.out.println("# baranch B`s sales")),
                Observable.fromIterable(SampleData.salesOfBranchC)
                        .delay(400L, TimeUnit.MILLISECONDS)
                        .doOnComplete(() -> System.out.println("# baranch C`s sales")));

        Observable.amb(observables)
                .doOnComplete(() -> System.out.println("# 완료"))
                .subscribe(System.out::println);

        Thread.sleep(1000L);
    }
}
