package com.design.awardDsitribute;

import java.util.HashMap;
import java.util.Map;

class StrategyContextSingleton {
    private static final Map<String, Strategy> registerMap = new HashMap<>();
    // 注册策略
    public static void registerStrategy(String rewardType, Strategy strategy){
        registerMap.putIfAbsent(rewardType, strategy);
    }
    // 获取策略
    public static Strategy getStrategy(String rewardType) {
        return registerMap.get(rewardType);
    }
}

// 抽象策略类
abstract class AbstractStrategy implements Strategy {
    // 类注册方法
    public void register() {
        StrategyContextSingleton.registerStrategy(getClass().getSimpleName(), this);
    }
}

class WaiMaiSingle extends AbstractStrategy implements Strategy {
    private static final WaiMaiSingle instance =  new WaiMaiSingle();
//    private 服务service 服务service;
    private void WaiMai() {
        register();;
    }
    public static WaiMaiSingle getInstance() {
        return instance;
    }

    @Override
    public void issue(Object... params) {
        // 具体实现
    }
}

/**
 * 饿汉单例模式
 */
public class Singleton {
}
