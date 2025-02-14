package com;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MyRxJava3 {
    public static void main(String[] args) throws InterruptedException {
        Observable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("RxJava3");
            emitter.onComplete();
        }).subscribe(System.out::println, Throwable::printStackTrace);

        Observable.create(emitter -> {
                    while (!emitter.isDisposed()) {
                        long time = System.currentTimeMillis();
                        emitter.onNext(time);
                        if (time % 2 != 0) {
                            emitter.onError(new IllegalStateException("Odd millisecond!"));
                            break;
                        }
                    }
                }).subscribe(System.out::println, Throwable::printStackTrace);

        Flowable.just("hello RxJava3").subscribe(System.out::println);

        Flowable.fromCallable(() -> {
                    Thread.sleep(1000); //  imitate expensive computation
                    return "Done";
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000); // <--- wait for the flow to finish

        Flowable<String> source = Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        });

        Flowable<String> runBackground = source.subscribeOn(Schedulers.io());
        Flowable<String> showForeground = runBackground.observeOn(Schedulers.single());
        showForeground.subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000);

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
