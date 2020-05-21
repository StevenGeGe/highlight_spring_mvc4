package com.wisely.highlight_spring_mvc4.ch4.y01.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Yong
 * @Date: 2020/4/21 16:17
 * @Version 1.0
 * @PACKAGE_NAME : com.wisely.highlight_spring_mvc4
 **/

/**
 * web配置
 *
 * 1、WebApplicationInitializer 是spring 提供用来配置Servlet 3.0+ 配置的接口，
 *      从而实现了替代web.xml 的位置。
 *      实现此接口将会自动呗SpringServletContainerInitializer（用来启动servlet 3.0 容器）获取到的。
 * 2、新建WebApplicationContext， 注册配置类，并将其和当前servletContext关联。
 * 3、注册Spring MVC 的DispatcherServlet。
 * */
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);  //1
        context.setServletContext(servletContext);  //2

        Dynamic servletRegistration =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));  //3
        servletRegistration.addMapping("/");
        servletRegistration.setLoadOnStartup(1);

    }
}
