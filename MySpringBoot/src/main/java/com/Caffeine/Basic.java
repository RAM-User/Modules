package com.Caffeine;

import com.github.benmanes.caffeine.cache.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class Basic {
    public static void getValue() throws Exception{
        // 构建cache对象
        Cache<String, String> cache = Caffeine.newBuilder()
                // 过期淘汰策略
                .expireAfterWrite(Duration.ofSeconds(5))
                // 存储容量
                .maximumSize(10_1000)
                // 记录命中
                .recordStats()
                // 定义线程池
                .executor(new Executor() {
                    @Override
                    public void execute(Runnable command) {

                    }
                })
                // 缓存移除监听
                .removalListener(new RemovalListener<String, String>() {
                    // 清理回调
                    @Override
                    public void onRemoval(@Nullable String s, @Nullable String s2, @NonNull RemovalCause removalCause) {
                        System.out.println(s + "is remove");
                    }
                })
                .build();

        // 存数据
        cache.put("1", "id = 1");
        cache.invalidate(1);

        Thread.sleep(10000);
        // 取数据
        String gf = cache.getIfPresent("1");
        System.out.println("1 = " + gf);
    }

    public static void sync() {
        AsyncLoadingCache<String, String> asyncLoadingCache = Caffeine.newBuilder()
                //创建缓存或者最近一次更新缓存后经过指定时间间隔刷新缓存；仅支持LoadingCache
                .refreshAfterWrite(2, TimeUnit.SECONDS)
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .expireAfterAccess(2, TimeUnit.SECONDS)
                .maximumSize(10)
                //根据key查询数据库里面的值
                .buildAsync(new CacheLoader<String, String>() {
                    @Override
                    public @Nullable String load(@NonNull String s) throws InterruptedException {
                        Thread.sleep(1000);
                        return new Date().toString();
                    }
                });

        CompletableFuture<String> future = asyncLoadingCache.get("1");
        future.thenAccept(System.out::println);

    }

    public static void main(String[] args) throws Exception {
        Basic.sync();
    }
}
