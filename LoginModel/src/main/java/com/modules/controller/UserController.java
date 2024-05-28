package com.modules.controller;

import com.modules.service.SysLoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysLoginService loginService;

    @ApiOperation(value = "网店管家商品获取")
    @RequestMapping(value = "/sysDefoeProductList", method = RequestMethod.GET)
    public String sysWdgjProductList() throws Exception {
        loginService.
    }
}
