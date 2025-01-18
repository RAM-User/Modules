package com.design.Task;

import java.util.ArrayList;
import java.util.List;

// 抽象观察者
interface Observer {
    // 反应
    void response(Long taskId);
}

// 抽象目标
abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();
    // 增加观察者方法
    public void add(Observer observer) {
        observers.add(observer);
    }
    // 删除观察者方法
    public void remove(Observer observer) {
        observers.remove(observer);
    }
    // 通知观察者方法
    public void notifyObserver(Long taskId) {
        for (Observer observer : observers) {
            observer.response(taskId);
        }
    }
}

// 活动观察者
class ActivityObserver implements Observer {
    // 特定实现service
    private Subject subject;
    @Override
    public void response(Long taskId) {
        // 特定实现
        subject.notifyObserver(taskId);
    }
}

// 任务管理观察者
class TaskManageObserver implements Observer {
    // private 任务管理;
    @Override
    public void response(Long taskId) {
        // 发布任务
    }
}

public class ObserverMode {
}
