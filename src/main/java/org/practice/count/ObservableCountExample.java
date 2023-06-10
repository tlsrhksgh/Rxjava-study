package org.practice.count;

import io.reactivex.Observable;
import org.practice.common.SampleData;

import java.util.Arrays;

public class ObservableCountExample {
    public static void main(String[] args) {
        Observable.concat(
                Arrays.asList(
                        Observable.fromIterable(SampleData.seoulPM10List),
                        Observable.fromIterable(SampleData.busanPM10List),
                        Observable.fromIterable(SampleData.incheonPM10List)
                )
        ).count().subscribe(System.out::println);
    }
}
