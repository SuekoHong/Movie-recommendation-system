package com.movies.controller;

import com.movies.common.E3Result;
import com.movies.domain.Movie;
import com.movies.domain.User;
import com.movies.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This class is controller layer with user of this system.
 * @author qing
 * @version 1.0
 *
 * @author victoria
 * @version 2.0
 *
 * @author sueko
 * @version 3.0
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll")
    public String findAll(){
        System.out.println("表现层查询所有账户信息");
        User user = new User();
        userService.userRegister(user);
        return "list";
    }
/**
    @RequestMapping("/page/register")
    public String userRegister(HttpServletRequest registerRequest) {
        String userId = null;
        User user;
        E3Result e3Result = E3Result.ok(userService.userRegister(user));
        if (e3Result.getStatus() == 200) {
            userId = (String) e3Result.getData();
        }
       // request.getSession().setAttribute("userId", userId);
        //return e3Result;

        //TopDefaultMoviesService topDefaultMoviesService=null;
        //List<Movie> movieList = topDefaultMoviesService.selectRegDefaultMovie();
        //保存数据
        //registerRequest.getSession().setAttribute("topRegDefaultMovie",movieList);
        return "register";
    }
    **/


    //进入登录页面
    @RequestMapping("/page/login")
    public String log() {
        return "login";
    }

}
