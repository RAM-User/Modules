package com;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class MyRxJava3 {
    public static void main(String[] args) {
        Observable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("RxJava3");
            emitter.onComplete();
        });

        Flowable.just("hello RxJava3").subscribe(System.out::println);

        new DisposableObserver<String>() {

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.err.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };


    }
}
