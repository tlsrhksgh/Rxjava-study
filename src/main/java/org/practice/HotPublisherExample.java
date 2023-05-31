package org.practice;

import io.reactivex.processors.PublishProcessor;

public class HotPublisherExample {
    public static void main(String[] args) {
        //Hotpublish example
        // 구독한 시점에 발행된 데이터만 전달 받을 수 있음. 그러므로 구독자2는 1,3 데이터는 받지 못함.
        PublishProcessor<Integer> processor = PublishProcessor.create();
        processor.subscribe(data -> System.out.println("구독자1: " + data));
        processor.onNext(1);
        processor.onNext(3);

        processor.subscribe(data -> System.out.println("구독자2: " + data));
        processor.onNext(5);
        processor.onNext(7);

        processor.onComplete();
    }
}
