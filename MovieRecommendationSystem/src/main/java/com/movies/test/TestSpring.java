package com.movies.test;

import com.movies.domain.User;
import com.movies.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void userLogInTest()
    {
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        IUserService userService = (IUserService) ac.getBean("userService");
        //调用方法
        User user = new User();
        userService.userRegister(user);

    }
}
