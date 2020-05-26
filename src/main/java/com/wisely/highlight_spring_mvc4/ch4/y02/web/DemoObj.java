package com.wisely.highlight_spring_mvc4.ch4.y02.web;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Yong
 * @Date: 2020/5/21 15:15
 * @Version 1.0
 * @PACKAGE_NAME : com.wisely.highlight_spring_mvc4.ch4.y02.web
 **/

/**
 * 传值类
 *
 * 此类用来演示获取request对象参数和返回此对象到response
 * <p>
 * 1、Jackson 对 对象 和json 做转换时一定需要此孔构造。
 */

public class DemoObj { //1
    private Long id;
    private String name;

    public DemoObj() {
        super();
    }

    public DemoObj(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
