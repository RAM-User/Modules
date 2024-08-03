package com.mySpringBoot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RequestMapping("/controllerAdvice")
@ControllerAdvice(basePackageClasses = MvcController.class)
//@Controller
public class MvcController extends ResponseEntityExceptionHandler {

    @GetMapping("/advice")
    public String controllerAdvice() {
        String message = "advice";
        try {
            return message;
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
