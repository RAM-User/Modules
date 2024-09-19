package com.modules.JUC;

import com.modules.JUC.Entity.Job;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * java延迟队列提供了在指定时间才能获取队列元素的功能，队列头元素是最接近过期的元素。
 * 没有过期元素的话，使用poll()方法会返回null值，超时判定是通过getDelay(TimeUnit.NANOSECONDS)方法的返回值小于等于0来判断。
 * 延时队列不能存放空元素。
 * 延时队列实现了Iterator接口，但iterator()遍历顺序不保证是元素的实际存放顺序。
 */
public class MyDelayQueue {
    public static void main(String[] args) throws InterruptedException {
        Job job1 = new Job("job1", 5, TimeUnit.SECONDS);
        Job job2 = new Job("job2", 10, TimeUnit.SECONDS);
        Job job3 = new Job("job3", 15, TimeUnit.SECONDS);

        DelayQueue<Job> jobDelayQueue = new DelayQueue<>();
        jobDelayQueue.put(job1);
        jobDelayQueue.put(job2);
        jobDelayQueue.put(job3);

        System.out.println("begin time: " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        for (int i = 0; i < 3; i++) {
            Job take = jobDelayQueue.take();
            System.out.format("name: %s, time: %s\n",take.getJobName(), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }

}
