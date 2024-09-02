package rule.service.impl;

import rule.service.AbstractHandler;

//@Order(2) // 排序
public class CheckSecurityFilterObject extends AbstractHandler {
    @Override
    protected void doFilter(Object object) {
        System.out.println("链点2");
    }
}
