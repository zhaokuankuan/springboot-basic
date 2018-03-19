package com.kk.springbootbasic.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Mr.kk
 * */
@RestController
public class HelloWorld {

    @RequestMapping(value = "{name}/hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String sayHelloPath(@PathVariable String name){
        return  "hello world!"+ name;
    }

    @RequestMapping(value = "/sayHello",method = {RequestMethod.GET,RequestMethod.POST})
    public String sayHello( String name){
        return  "hello world!"+ name;
    }
}
