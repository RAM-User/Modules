package com.design.awardDsitribute;

/**
 *  抽象策略类
 */
interface Strategy {
    void issue(Object ... params);
}

/**
 * 具体策略
 */
class WaiMai implements Strategy {
    @Override
    public void issue(Object... params) {
        // 具体实现
    }
}

class JiuDian implements Strategy {
    @Override
    public void issue(Object... params) {
        // 具体实现
    }
}

/**
 * 环境类
 */
class StrategyContext {
    public static Strategy getStrategy(String rewardType) {
        switch (rewardType) {
            case "WaiMai": return new WaiMai();
            case "JiuDian": return new JiuDian();
            default: throw new IllegalArgumentException("reward type error!");
        }
    }
}

public class AwardAllocate {
    public static void main(String rewardType, Object ... params) {
        Strategy strategy = StrategyContext.getStrategy(rewardType);
        strategy.issue(params);
    }
}
