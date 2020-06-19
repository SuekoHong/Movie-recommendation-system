package com.movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController2 {
    //进入注册页面
    @RequestMapping("/page/register")
    public String reg(HttpServletRequest request) {
        /**
         //选择topmovies给用户选择她喜欢的电影
         List<Movie> list = topDefaultMoviesService.SelectRegDefaultMovie();
         request.getSession().setAttribute("TopRegDefaultMovie",list);
         **/
        return "register";
    }
    //进入登录页面
    @RequestMapping("/page/login")
    public String log() {
        return "login";
    }
    /***
    //对用户进行注册(在全部检查完成后)
    @RequestMapping(value = "/customer/register", method = RequestMethod.POST)
    @ResponseBody
    public E3Result register(User user,HttpServletRequest request) {
        //修改3.18 返回用户id,用于用户选择喜欢的电影后把相应信息存broswer表
        Integer userId = 0;
        E3Result e3Result = registerService.register(user);
        if (e3Result.getStatus() == 200) {
            userId = (Integer) e3Result.getData();
        }
        request.getSession().setAttribute("userId", userId);
        return e3Result;
    }

    //新用户选择喜欢的电影
    @RequestMapping(value = "/customer/register/movieSubmit",method = RequestMethod.POST)
    @ResponseBody
    public String  selectedMovie(String ids ,HttpServletRequest request){
        //没有选择电影则不插入数据
        if(ids== "" || ids==null){
            System.out.print("为空");
            return  "fail";
        }
        else {
            //获取的用户id
            Integer userId = (Integer) request.getSession().getAttribute("userId");
       /* //获取点击的时间戳
        String str = request.getParameter("time");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = format.parse(str);


    ****/
/***
            //这个是类的作用是把用户点击过的电影信息传回后台
            //返回信息包括用户ID、电影ID
            Browse browse = new Browse();
            //存用户名
            browse.setUserid(userId);
            browse.setmovieids(ids);
            registerService.selectFavorite(browse);
            return "ok";
        }

    }
***/

/***
    // 判断登录账号是否存在
    @RequestMapping(value = "/customer/login", method = RequestMethod.POST)
    @ResponseBody
    public E3Result login(String username, String password, Model model, HttpServletRequest request) {
        E3Result e3Result = loginService.userLogin(username, password);
        User user = null;
        // 判断是否登录成功
        if (e3Result.getStatus() == 200) {
            user = (User) e3Result.getData();
        }
        request.getSession().setAttribute("user", user);
        // 返回结果
        return e3Result;
    }

    **/

    //用户退出
    @RequestMapping("/page/logout")
    public String pagelogout( HttpServletRequest request){
        //注销seesion
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("userstar");
        request.getSession().removeAttribute("reviews");
        request.getSession().removeAttribute("booluserunlikedmovie");
        request.getSession().removeAttribute("TopRegDefaultMovie");
        return "Home";

    }



/*****
    // 更新用户密码
    @RequestMapping("/user/update")
    @ResponseBody
    public String updateUser(HttpServletRequest request) {
        String useridstr = request.getParameter("userid");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Integer userid = Integer.parseInt(useridstr);
        // 修改密码

        userService.updateUser(userid, password, email);
        return "OK";
    }

    @RequestMapping("/user/edit")
    @ResponseBody
    public User getUserById(Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

    *************/
}
