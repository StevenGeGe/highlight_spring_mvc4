package com.wisely.highlight_spring_mvc4.ch4.y01.web;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Yong
 * @Date: 2020/4/21 17:12
 * @Version 1.0
 * @PACKAGE_NAME : com.wisely.highlight_spring_mvc4.ch4.y01.web
 **/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1、利用@Controller 注解声明是一个控制器。
 * 2、理应@RequestMapping 配置URL 和方法之间的映射。
 * 3、通过上面ViewResolver 的Bean配置，返回值为index， 说明我们的页面放置的路径为
 *      /WEB-INF/classes/views/index.jsp
 */
@Controller  //1
public class HelloController {

    @RequestMapping("/index")  //2
    public String hello() {
        return "index";  //3
    }
}
