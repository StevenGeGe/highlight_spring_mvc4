package com.wisely.highlight_spring_mvc4.ch4.y02.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Yong
 * @Date: 2020/5/26 12:30
 * @Version 1.0
 * @PACKAGE_NAME : com.wisely.highlight_spring_mvc4.ch4.y02.web
 **/


/**
 * @RestController演示类 1、使用RestController， 声明是控制器，并且返回数据时不需要@ResponseBody 。
 * 2、返回数据的媒体类型为json
 * 3、直接返回对象，对象会自动转成json
 * 4、返回数据的媒体类型为xml
 * 5、直接返回对象，会自动转成xml
 */

@RestController  //1
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getJson", produces = {"application/json;charset=UTF-8"})  //2
    public int getJson(DemoObj obj) {/*
        return new DemoObj(obj.getId() + 1, obj.getName() + "xx");  //3
   */
        return 1;
    }

    @RequestMapping(value = "/getXml", produces = {"application/xml;charset=UTF-8"})  //4
    public DemoObj getXml(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "yy");  //5
    }
}
