package com.kk.springbootbasic.controller;

import com.kk.springbootbasic.dao.UserDetailRepository;
import com.kk.springbootbasic.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserDetailController {

    @Autowired
    private UserDetailRepository userDetailRepository;

    //联查
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public Object getUserInfo(){
        List<UserInfo> list = userDetailRepository.findUserInfo("篮球");
        return  list;
    }

    //jpa的多数据源配置
    @RequestMapping(value = "/testMulitDatabase",method = RequestMethod.GET)
    public Object testMulitDatabase(){

        return  "ok";
    }

}
