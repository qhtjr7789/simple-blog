package com.example.blog.controller;


import com.example.blog.vo.HelloWorldBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //1. get -> Hello-world
    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    public HelloWorldBean helloworld() {
        HelloWorldBean helloWorldBean = new HelloWorldBean("Hello-world");


        return helloWorldBean;
    }
    //2. get -> Hello-world-bean
    @RequestMapping(value = "/hello-world-bean", method = RequestMethod.GET)
    public HelloWorldBean hellobean() {
        HelloWorldBean helloWorldBean = new HelloWorldBean("Hello-world-bean");


        return helloWorldBean;
    }
    //3. get -> Hello-world/path-variable/{name}
    @RequestMapping(value = "/hello-world/path-variable/{name}", method = RequestMethod.GET)
    public HelloWorldBean hellovar(
            @PathVariable("name") String name
    ) {
        HelloWorldBean helloWorldBean = new HelloWorldBean(String.format("Hello-world-var %s", name));


        return helloWorldBean;
    }
}
