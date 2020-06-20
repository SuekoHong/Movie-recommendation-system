package com.movies.service.Impl;

import com.movies.dao.IUserDao;
import com.movies.domain.User;
import com.movies.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userService")
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public String userRegister(User user1) {
        User user = new User();
        Date myDate = new Date(1999/03/26);
        user.setUserBirthday(myDate);
        user.setUserEmail("123@123.com");
        user.setUserGender("男");
        user.setUserName("Test");
        user.setUserTel("1234");
        user.setUserPassword("2344656");
        userDao.saveUser(user);
        String userId = user.getUserTel();
        return userId;
    }

    @Override
    public boolean userLogIn(User user) {
        return false;
    }

    @Override
    public boolean userLogOut(User user) {
        return false;
    }

    @Override
    public boolean userChangePassword(User user) {
        return false;
    }

    @Override
    public boolean userChangeName(User user) {
        return false;
    }

    @Override
    public void findAll() {
        System.out.println("查询所有");
    }

}
