package com.modules.JUC.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Data
@NoArgsConstructor
public class Job implements Delayed {
    private Long time;

    private String jobName;

    public Job(String jobName, long time, TimeUnit unit) {
        this.jobName = jobName;
        this.time = System.currentTimeMillis() + (time > 0? unit.toMillis(time): 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return this.time - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Job job = (Job) o;
        long diff = this.time - job.time;

        // 判断认识是否到期
        if (diff <= 0) {
            return -1;
        }
        return 1;
    }

}
