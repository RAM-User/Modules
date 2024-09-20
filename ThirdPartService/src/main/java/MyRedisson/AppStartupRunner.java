package MyRedisson;

import Entity.User;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * spring-boot项目启动完成运行
 */
@Component
public class AppStartupRunner implements CommandLineRunner {

    @Autowired
    private RedissonClient redissonClient;


    @Override
    public void run(String... args) {
        User user = new User();
        user.setUserName("userName");
        user.setUserId("1");
        user.setPassword("password");

        RBlockingDeque<User> blockingDeque = redissonClient.getBlockingDeque("demoName");
        RDelayedQueue<User> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);

        // 单位
        delayedQueue.offer(user, 5, TimeUnit.SECONDS);
        //记录设置任务的时间
        System.out.println(user.getUserId() + "添加时间是：" + LocalDateTime.now());
        //开启新线程执行任务，不阻塞主线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    User user2 = blockingDeque.poll();
                    if (user2 != null) {
                        System.out.println(user2);
                        System.out.println(user2.getUserId() + "执行时间是：" + LocalDateTime.now());
                    }
                }
            }
        }).start();
    }
}
