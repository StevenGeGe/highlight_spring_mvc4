package com.wisely.highlight_spring_mvc4.ch4.y01.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Yong
 * @Date: 2020/4/21 16:00
 * @Version 1.0
 * @PACKAGE_NAME : PACKAGE_NAME
 **/

/**
 * spring mvc 配置
 * <p>
 * 1、spring mvc 的ViewResolver , 这是spring MVC视图（jsp 下就是html）渲染的核心机制；
 * 2、spring mvc 里有一个接口叫做ViewResolver（我们的ViewResolver都实现该接口），
 * 实现这个接口要重写方法resolveViewName（），这个方法的返回值是接口 View，
 * 而View 的职责就是使用model， request， response对象，
 * 并将渲染的视图（不一定是html，可能是json， xml， pdf）返回给浏览器。
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.wisely.highlight_spring_mvc4.ch4.y01.web")
public class MyMvcConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

}
