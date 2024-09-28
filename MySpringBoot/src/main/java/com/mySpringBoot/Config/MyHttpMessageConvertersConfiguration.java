//package com.mySpringBoot.Config;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//
//import java.util.ArrayList;
//
//@Configuration(proxyBeanMethods = false)
//public class MyHttpMessageConvertersConfiguration {
//
//    @Bean
//    public HttpMessageConverters customConverters() {
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//        ArrayList<MediaType> mediaTypes = new ArrayList<>();
//        mediaTypes.add(MediaType.APPLICATION_JSON);
//
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//
//        return new HttpMessageConverters(fastJsonHttpMessageConverter);
//    }
//}
