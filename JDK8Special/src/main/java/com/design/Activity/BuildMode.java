//package com.design.Activity;
//
//// 抽象活动接口
//interface ActivityInterface {
//    void participate(Long userId);
//}
//
//// 活动类
//class Activity implements ActivityInterface {
//    protected String type;
//    protected Long id;
//    protected String name;
//    protected Integer scene;
//    protected String material;
//
//    // 全参构造函数
//    public Activity(String type, Long id, String name, Integer
//            scene, String material) {
//        this.type = type;
//        this.id = id;
//        this.name = name;
//        this.scene = scene;
//        this.material = material;
//    }
//
//    @Override
//    public void participate(Long userId) {
//        // do nothing
//    }
//
//    // 抽象建造者
//    // 静态建造器类，使用奇异递归模板模式允许继承并返回继承建造器类
//    public static class Builder<T extends Builder<T>> {
//        protected String type;
//        protected Long id;
//        protected String name;
//        protected Integer scene;
//        protected String material;
//
//        public T setType(String type) {
//            this.type = type;
//            return (T) this;
//        }
//
//        public T setId(Long id) {
//            this.id = id;
//            return (T) this;
//        }
//
//        public T setId() {
//            if ("period".equals(this.type)) {
//                this.id = 0L;
//            }
//            return (T) this;
//        }
//
//        public T setScene(Integer scene) {
//            this.scene = scene;
//            return (T) this;
//        }
//
//        public T setMaterial(String material) {
//            this.material = material;
//            return (T) this;
//        }
//
//        public T setName(String name) {
//            if ("period".equals(this.type)) {
//                this.name = "period" + name;
//            } else {
//                this.name = "period" + name;
//            }
//            return (T) this;
//        }
//
//        public Activity build() {
//            return new Activity(type, id, name, scene, material);
//        }
//    }
//}
//
//// 任务型活动
//class TaskActivity extends Activity {
//    protected TaskActivity task;
//    // 全参构造函数
//    public TaskActivity(String type, Long id, String name, Integer
//            scene, String material, TaskActivity task) {
//        super(type, id, name, scene, material);
//        this.task = task;
//    }
//    // 参与任务型活动
//    @Override
//    public void participate(Long userId) {
//        // 更新任务状态为进行中
//        task.getState().update(task, ActionType.START);
//    }
//    // 继承建造器类
//    public static class Builder extends Activity.Builder<Builder> {
//        private Task task;
//        public Builder setTask(Task task) {
//            this.task = task;
//            return this;
//        }
//        public TaskActivity build(){
//            return new TaskActivity(type, id, name, scene, material, task);
//        }
//    }
//}
//
//// 产品角色
//
//// 具体建造者
//
//// 指挥者
