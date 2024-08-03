package com.mySpringBoot;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@EnableTransactionManagement
@ServletComponentScan
@ComponentScan({"com.example"})//扫描异常类
@MapperScan({"com.example.event_resource_java.*.mapper","com.example.event_resource_java.*.dao"})
@SpringBootApplication
@EnableDiscoveryClient    //服务注册
@EnableFeignClients  //服务调用
@EnableScheduling   //定时任务
public class EventResourceJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventResourceJavaApplication.class, args);
    }

}
