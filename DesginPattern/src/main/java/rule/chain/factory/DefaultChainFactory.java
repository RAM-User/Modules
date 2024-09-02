package rule.chain.factory;

import rule.service.AbstractHandler;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

// @Component
public class DefaultChainFactory {

    @Resource
    private List<AbstractHandler> abstractHandlerList;

    private AbstractHandler abstractHandler;

    /**
     * 链式结构组装
     */
    @PostConstruct
    public void initialChainFilter() {
        for (int i = 0; i < abstractHandlerList.size(); i++) {
            if (i == 0) {
                abstractHandler = abstractHandlerList.get(0);
            }{
                // 组装成链
                AbstractHandler currentHandler = abstractHandlerList.get(i - 1);
                AbstractHandler nextHandler = abstractHandlerList.get(i);
                currentHandler.setNextHandler(nextHandler);
            }
        }
    }

    /**
     * 树形结构组装
     */

    /**
     * 开始责任链处理
     * @param object
     */
    public void execute(Object object) {
        abstractHandler.filter(object);
    }
}
