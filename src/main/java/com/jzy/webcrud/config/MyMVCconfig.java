package com.jzy.webcrud.config;

import com.jzy.webcrud.component.LoginHandlerInterceptor;
import com.jzy.webcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc
@Configuration
//public class MyMVCconfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//    }
//}

public class MyMVCconfig implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**").excludePathPatterns("/","/index.html","/user/login");
//
//    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}




//public class MyMVCconfig extends WebMvcConfigurationSupport{
//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("index");
//
//    }
//}