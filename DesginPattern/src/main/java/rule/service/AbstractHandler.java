package rule.service;

/**
 * 责任链模式：
 *      有一个指向责任下一个对象的属性
 *      一个设置下一个对象的set方法
 *      给子类对象差异化实现的方法（如以下代码的doFilter方法）
 */
public abstract class AbstractHandler {

    /**
     * 下一个节点
     */
    private AbstractHandler nextHandler;

    /**
     * 具体逻辑处理
     *
     * @param object
     */
    public void filter(Object object) {
        doFilter(object);
        // 往下执行
        if (getNextHandler() != null) {
            getNextHandler().filter(object);
        }
    }

    /**
     * 获取下一个对象
     *
     * @return
     */
    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    /**
     * 插入下一个对象
     *
     * @param nextHandler
     */
    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void doFilter(Object object);
}
