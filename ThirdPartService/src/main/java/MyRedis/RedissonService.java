package MyRedis;

import Entity.User;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedissonService {

    @Autowired
    private RedissonClient redissonClient;

    public void addDelay() {
        RBlockingQueue<User> blockingFairQueue = redissonClient.getBlockingQueue("delay_queue_call");
        RDelayedQueue<User> delayedQueue = redissonClient.getDelayedQueue(blockingFairQueue);
        delayedQueue.offer(new User(), 5, TimeUnit.SECONDS);
        // 不要调用下面的方法,否者会导致消费不及时
//        delayedQueue.destroy();
    }

}
