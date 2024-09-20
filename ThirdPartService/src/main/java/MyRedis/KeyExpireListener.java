package MyRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.util.Objects;

@Configuration
public class KeyExpireListener extends JedisPubSub {

    @Autowired
    private JedisPool jedisPool;

    @Bean
    public KeyExpireListener getBean() {
        return  new KeyExpireListener();
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        super.onPUnsubscribe(pattern, subscribedChannels);
    }

    // 接收过期消息
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        if (Objects.isNull(message)) {
            return;
        }

        if (message.indexOf("SALE_PURCHASE_STOP") != -1) {
            Jedis jedis = jedisPool.getResource();
            String exKey = message + "Ex";
            String orderId = jedis.get(exKey);
            if (Objects.isNull(orderId) || orderId == "") {
                jedis.del(exKey);
                jedis.close();
                return;
            }
        }
    }
}
