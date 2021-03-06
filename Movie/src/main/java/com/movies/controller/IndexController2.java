package com.movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController2 {
    //主页
    @RequestMapping("/")
    public String showHomepage( HttpServletRequest request){
        /***
        User user=(User) request.getSession().getAttribute("user");
        //用户登录则推荐他的电影否则推荐默认电影（固定五部）

        if(user!=null)
        {
            List<Movie> movies = new ArrayList<Movie>();

            // 从ALS表中查询推荐强度8以上的电影
            List<Movie> alsMovies = alsService.selectAlsMoviesByUserId(user.getUserid());
            for (Movie alsMovie : alsMovies) {
                movies.add(alsMovie);
            }

            Rectab rectab = rectabService.getRectabByUserId(user.getUserid());
            if (rectab!=null && null != rectab.getMovieids()) {
                String movieids =rectab.getMovieids();
                String[] strmovieids = movieids.split(",");
                int i = 0;
                for (String strmovieid: strmovieids) {
                    if(i==5)
                        break;
                    Integer movieid = Integer.parseInt(strmovieid);
                    Movie movie = movieService.getMovieByMovieid(movieid);
                    if(movie !=null)
                        movies.add(movie);
                    i++;
                }
            }
            //不足五部从默认电影中凑齐五部
            if(movies.size()<5)
            {
                E3Result TopDefaultMovie = movieService.SelectTopDefaultMovie(5-movies.size());
                List<Movie> temp = (List<Movie>)TopDefaultMovie.getData();
                movies.addAll(temp);

            }
            //将电影信息放在map中转Json再进入session给前端 map中存放movieid
            request.getSession().setAttribute("TopDefaultMovie",movies);
            Map moviemap = new HashMap();
            for(int i = 0 ; i < movies.size() ; i++) {
                moviemap.put(movies.get(i).getMovieid().toString(), i);
            }
            request.getSession().setAttribute("TopDefaultMovieMap",JsonUtils.objectToJson(moviemap));
        }
        else
        {
            E3Result TopDefaultMovie = movieService.SelectTopDefaultMovie(5);
            List<Movie> list = (List<Movie>)TopDefaultMovie.getData();
            request.getSession().setAttribute("TopDefaultMovie",list);
            Map moviemap = new HashMap();
            for(int i = 0 ; i < list.size() ; i++) {
                moviemap.put(list.get(i).getMovieid().toString(), i);
            }
            request.getSession().setAttribute("TopDefaultMovieMap",JsonUtils.objectToJson(moviemap));
        }
         ****/
        return "Home";
    }
    //选电影界面
    @RequestMapping("/index")
    public String showIndex( HttpServletRequest request){
        //获取所有分类标签
        /****
        E3Result e3ResultAllCategory = categoryService.GetAllCategory();
        List<Category> list1 = (List<Category>)e3ResultAllCategory.getData();
        //获取所有电影数据(缺少筛选，默认一次加载20个)
        Integer Categoryid=0;
        Selectquery query=new Selectquery();
        query.setCategoryid(Categoryid);
        query.setmolimit(0);
        query.setSort("numrating");
        E3Result e3ResultAllMoive = movieService.SortMoiveBycategory(query);
        List<Movie> list2 = (List<Movie>)e3ResultAllMoive.getData();
        //设置SEESION
        request.getSession().setAttribute("category",list1);
        request.getSession().setAttribute("movie",list2);
         ****/
        return "index";
    }
/***
    //电影详情传值
    @RequestMapping("/Customer/Description")
    @ResponseBody
    public String GoMoiveDescription(HttpServletRequest request) {
        /****
        request.getSession().removeAttribute("booluserunlikedmovie");
        //获取用户点击的movieid
        int  movieid=Integer.parseInt(request.getParameter("id"));
        E3Result e3Result1 = movieService.SortMoiveByMovieid(movieid);
        //用户所点击的电影详情信息movie
        Movie movie = (Movie) e3Result1.getData();
        User user=(User) request.getSession().getAttribute("user");
        //判断用户是否登录以及对这部电影的喜爱
        if(user!=null)
        {
            E3Result e3Result2 = starService.SortReviewByUseridandMovieid(user.getUserid(), movieid);
            Review review = (Review) e3Result2.getData();
            request.getSession().setAttribute("userstar", review);
            //判断登录用户是否喜欢该电影
            int booluserlikedmovie=movieService.booluserunlikedmovie(user.getUserid(),request.getParameter("id"));
            request.getSession().setAttribute("booluserunlikedmovie", booluserlikedmovie);
        }
        else
        {
            Review review = null;
            //用户评分
            request.getSession().setAttribute("userstar", review);
        }
        //设置session
        request.getSession().setAttribute("moviedescription",movie);

        return "success";

    }
***/
    //电影详情界面
    @RequestMapping("/MovieDescription")
    public String showMoiveDescription(HttpServletRequest request){
        return "MovieDescription";
    }

    /***

     //电影评星
     @RequestMapping(value = "/getstar", method = RequestMethod.POST)
     @ResponseBody
     public String getstar(HttpServletRequest request) throws ParseException {
     int userid = Integer.parseInt(request.getParameter("userid"));
     int movieid = Integer.parseInt(request.getParameter("movieid"));
     Double star = Double.parseDouble(request.getParameter("star"));
     if(star>=3.5) {

     // 查询本地相似表
     String movieds = movieService.Select5SimilarMovies(movieid);
     // 判断数据库是否有该userid
     Rectab rectab = rectabService.getRectabByUserId(userid);
     Rectab rec = new Rectab();
     rec.setUserid(userid);
     rec.setMovieids(movieds);
     // 没有则插入数据库
     if (null == rectab) {
     rectabService.insert(rec);
     } else {
     rectabService.update(rec);
     }

     }
     String str = request.getParameter("time");
     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     Date time = format.parse(str);
     Review review = new Review();
     review.setUserid(userid);
     review.setMovieid(movieid);
     review.setStar(star);
     review.setReviewtime(time);
     //写入数据库
     starService.setStar(review);
     review=null;
     E3Result e3Result = starService.SortReviewByUseridandMovieid(userid, movieid);
     review = (Review) e3Result.getData();
     //立即读取影评显示于前端
     request.getSession().setAttribute("userstar", review);
     return "success";
     }

     //电影详情界面点击相似电影
     @RequestMapping(value = "/getSimiMovies", method = RequestMethod.POST)
     @ResponseBody
     public E3Result getSimiMovies(HttpServletRequest request) throws ParseException {
     int id = Integer.parseInt(request.getParameter("id"));
     E3Result e3Result = movieService.Select5SimilarMoviesById(id);
     List<Movie> simiMovies = (List<Movie>)e3Result.getData();
     e3Result=E3Result.ok(simiMovies);
     return e3Result;
     }
     ***/
//个人中心按钮
    @RequestMapping("/profile")
    public String showProfie() {
        return "profile";
    }
/***
 //搜索电影
 @RequestMapping(value = "/search", method = RequestMethod.POST)
 @ResponseBody
 public E3Result selectMoviesByName(HttpServletRequest request){
 String moviename = request.getParameter("search_text");
 if(moviename == null || moviename ==""){
 System.out.print("不能为空");
 return null;
 }
 else{
 System.out.print("搜索内容"+moviename);
 List<Movie> list = movieService.selectMoviesByName(moviename);

 E3Result e3Result = E3Result.ok(list);
 return e3Result;
 }



 }

 ***/
}
