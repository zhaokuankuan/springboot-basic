package com.kk.springbootbasic.controller;

import com.kk.springbootbasic.dao.UserRepository;
import com.kk.springbootbasic.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/addUser",method = {RequestMethod.GET,RequestMethod.POST})
    public Object addUser(){
        userRepository.save(new User("aa", "aa@126.com", "aa", "aa123456","2016-01-01"));
        userRepository.save(new User("bb", "bb@126.com", "bb", "bb123456","2016-02-01"));
        userRepository.save(new User("cc", "cc@126.com", "cc", "cc123456","2016-03-01"));
        return "新增成功";
    }

    //按照名字查询
    @RequestMapping(value = "/findByUserName",method = RequestMethod.GET)
    public User findByUserName(String name){
        return  userRepository.findByUserName(name);
    }

    //按照名字和email查询
    @RequestMapping(value = "/findByUserNameOrEmail",method = RequestMethod.GET)
    public User findByUserNameOrEmail(String name,String email){
        return  userRepository.findByUserNameOrEmail(name,email);
    }

    //全查所有的对象
    @RequestMapping(value ="/getUserALL",method = RequestMethod.GET)
    public List<User> getUserALL(){
        return userRepository.findAll();
    }

    //保存对象传入的参数为一个对象
    @RequestMapping(value = "/saveUser",method = RequestMethod.GET)
    public Object saveUser(){
        User user = new User();
        user.setEmail("zhaokk@yonyou.com");
        user.setNickName("zhaokk");
        user.setRegTime("2019-0-1");
        user.setPassword("aa123");
        user.setUserName("赵宽宽");
        userRepository.save(user);
        return  "保存对象成功！";
    }

    //分页查询
    @RequestMapping(value = "/getUserByPage",method = RequestMethod.GET)
    public Object getUserByPage(){
        int page=1,size=2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> sa = userRepository.findALL(pageable);
        Page<User> sa1 = userRepository.findByNickName("zhaokk", pageable);
        return  sa1;
    }

    //自定义的根据id修改名称
    @RequestMapping(value = "/modifyById",method = RequestMethod.GET)
    public Object modifyById(){
        userRepository.modifyById("杨帆",20l);
        return  "ok";
    }

}
