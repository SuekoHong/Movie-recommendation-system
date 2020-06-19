package com.movies.controller;

import com.movies.common.E3Result;
import com.movies.domain.Movie;
import com.movies.domain.User;
import com.movies.service.LogInService;
import com.movies.service.RegisterService;
import com.movies.service.TopDefaultMoviesService;
import com.movies.common.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This class is about several operations of the user .
 *
 * register/log in...
 *
 * @author qing
 * @version 1.0
 *
 * @author victoria
 * @version 2.0
 */
@Controller
public class UserController {

    private UserService userService = null;

    /**
     * This request is the "注册" .
     * register
     *
     * @param registerRequest
     * @return
     */
    @RequestMapping("/page/register")
    public String reg(HttpServletRequest registerRequest) {

        TopDefaultMoviesService topDefaultMoviesService=null;
        List<Movie> movieList = topDefaultMoviesService.selectRegDefaultMovie();
        //保存数据
        registerRequest.getSession().setAttribute("topRegDefaultMovie",movieList);
        return "Register";
    }

    /**
     * log in
     *
     * @return
     */
    @RequestMapping("/LogIn")
    public String log() {
        return "LogIn";
    }

    //对用户进行注册(在全部检查完成后)

    /**
     * When the user complete registration information and click the "注册成功"
     * 有点不懂这个函数
     *
     * @param registerUser
     * @param registerSuccessRequest
     * @return
     */
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    @ResponseBody
    public E3Result register(User registerUser, HttpServletRequest registerSuccessRequest) {
        //修改3.18 返回用户id,用于用户选择喜欢的电影后把相应信息存broswer表
        Integer userId = 0;
        RegisterService registerService=null;
        E3Result e3Result = registerService.register(registerUser);
        if (e3Result.getStatus() == 200) {
            userId = (Integer) e3Result.getData();
        }
        registerSuccessRequest.getSession().setAttribute("userId", userId);
        return e3Result;
    }

    /**
     * This request is the "登录" .
     * When completing the information .
     * 唔，这里咱们不是用户名登录，但是看雪晴的那个界面，用户注册时用户名不能重复，这里也就可以用用户名登陆
     *
     * @param userName
     * @param password
     * @param model
     * @param logInRequest
     * @return
     */
    @RequestMapping(value = "/LogIn", method = RequestMethod.POST)
    @ResponseBody
    public E3Result login(String userName, String password, Model model, HttpServletRequest logInRequest) {
        LogInService loginService=null;
        E3Result e3Result = loginService.userLogin(userName, password);
        User user = null;
        // 判断是否登录成功
        if (e3Result.getStatus() == 200) {
            user = (User) e3Result.getData();
        }
        logInRequest.getSession().setAttribute("user", user);

        return e3Result;
    }


    /**
     * 用户注销
     * 下面的参数不是很懂
     *
     * @param logOutRequest
     * @return
     */
    @RequestMapping("/logout")
    public String pageLogOut( HttpServletRequest logOutRequest){
        //注销seesion
        logOutRequest.getSession().removeAttribute("user");
        logOutRequest.getSession().removeAttribute("userId");
        //logOutRequest.getSession().removeAttribute("userStar");
        logOutRequest.getSession().removeAttribute("reviews");
        //logOutRequest.getSession().removeAttribute("booluserunlikedmovie");
        logOutRequest.getSession().removeAttribute("topRegDefaultMovie");
        return "Home";

    }


    /**
     * update password
     *
     * @param updatePasswordRequest
     * @return
     */
    @RequestMapping("/user/update")
    @ResponseBody
    public String updateUser(HttpServletRequest updatePasswordRequest) {
        String userTel = updatePasswordRequest.getParameter("userTel");
        String password = updatePasswordRequest.getParameter("password");
        String email = updatePasswordRequest.getParameter("email");

        User userUpdate=new User();
        userUpdate.setUserTel(userTel);
        userUpdate.setUserEmail(email);
        userUpdate.setUserPassword(password);

        return "OK";
    }

}
