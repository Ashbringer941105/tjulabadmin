package com.lab_admin.lab_admin;

import com.lab_admin.lab_admin.interceptor.LoginInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    public MyWebAppConfigurer(){
        super();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("file:../image/").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("11");
        this.applicationContext = applicationContext;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //System.out.println("111");
        //拦截规则：除了"/index","/activities"之外都拦截，然后根基interceptor
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/loginVerify","/index");
        super.addInterceptors(registry);
    }

}
