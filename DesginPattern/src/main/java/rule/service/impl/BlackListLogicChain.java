package rule.service.impl;

import rule.service.AbstractHandler;

public class BlackListLogicChain extends AbstractHandler {
    @Override
    protected void doFilter(Object object) {
        System.out.println("链点3");
    }
}
