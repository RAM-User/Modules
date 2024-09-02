package rule.service.impl;

import rule.service.AbstractHandler;

//@Order(1) // 排序
public class CheckParamFilterObject extends AbstractHandler {
    @Override
    protected void doFilter(Object object) {
        System.out.println("链点1");
    }
}
