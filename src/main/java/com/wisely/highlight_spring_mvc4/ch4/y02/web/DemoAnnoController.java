package com.wisely.highlight_spring_mvc4.ch4.y02.web;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Yong
 * @Date: 2020/5/21 15:43
 * @Version 1.0
 * @PACKAGE_NAME : com.wisely.highlight_spring_mvc4.ch4.y02.web
 **/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 注解演示控制器
 * <p>
 * 1、@Controller 注解声明此类是一个控制器
 * 2、@RequestMapping("/anno") 映射此类访问路径是 /anno
 * 3、此方法未标注路径，因此使用类级别的路径/anno; produces 可定制返回的response 媒体类型和字符集，
 * 或需返回值是json 对象，则设置produce=“application/json;charset=UTF-8”,
 * 在后面的章节我们会演示此项特性。
 * 4、演示可接受HTTPServletRequest 作为参数，当然也可以接受 HttpServletResponse 作为参数.
 * 此处的@ResponseBody用在返回值前面。
 * 5、演示接受路径参数，并在方法参数前结合@PathVariable 使用，访问路径为 /anno/pathvar/xx .
 * 6、演示常规的request 参数获取， 访问路径 /anno/obj?id=1&name=xx .
 * 7、演示解释参数到对象，访问路径为 /anno/obj?id=1&name=xx .
 * 8、@ResponseBody 也可以用在方法上。
 * 9、演示映射不同的路径到相同的方法，访问路径 /anno/name1 或 /annon/name2 .
 */
@Controller  //1
@RequestMapping("/anno")  //2
public class DemoAnnoController {
    @RequestMapping(produces = "text/plain;charset=UTF-8")  //3
    public @ResponseBody
    String index(HttpServletRequest request) {  //4
        return "url:" + request.getRequestURL() + " can access";
    }

    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")  //5
    public @ResponseBody
    String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,str:" + str;
    }

    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")  //6
    public @ResponseBody
    String passRequestParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,id:" + id;
    }

    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")  //7
    public String passObj(DemoObj demoObj, HttpServletRequest request) {
        return "url" + request.getRequestURL() + " can access, obj id: " + demoObj.getId() + " obj name: " + demoObj.getName();
    }

    @RequestMapping(value = {"/name1", "/name3"}, produces = "text/plain;charset=UTF-8")  //8
    public @ResponseBody
    String remove(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }
}
