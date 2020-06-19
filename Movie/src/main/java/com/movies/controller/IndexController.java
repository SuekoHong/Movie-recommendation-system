package com.movies.controller;

import com.movies.common.E3Result;
import com.movies.common.JsonUtils;
import com.movies.domain.Movie;
import com.movies.service.TopDefaultMoviesService;
import com.movies.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is about the function of main interface .
 * @author qing
 * @version 1.0
 *
 * @author victoria
 * @version 2.0
 */
@Controller
public class IndexController {
    TopDefaultMoviesService moviesDisplay;
    //主页

    /**
     *This method is about the several movies on the main interface .
     *
     * @param homeRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/")
    public String showHomepage( HttpServletRequest homeRequest) throws Exception {

        //test
        MovieService movieObject=null;
        E3Result topDefaultMovie = movieObject.selectTopDefaultMovie(5);
        List<Movie> list = (List<Movie>)topDefaultMovie.getData();
        homeRequest.getSession().setAttribute("topDefaultMovie",list);
        Map movieMap = new HashMap();
        for(int i = 0 ; i < list.size() ; i++) {
            movieMap.put(list.get(i).getId().toString(), i);
        }
        homeRequest.getSession().setAttribute("topDefaultMovieMap",JsonUtils.objectToJson(movieMap));

        return "Home";
    }

    /**
     * This request is the "选电影" .
     *
     * @param selectMovieRequest
     * @return
     */
    @RequestMapping("/Index")
    public String showIndex( HttpServletRequest selectMovieRequest){
        //获取所有分类标签
        return "Index";
    }

    /**
     * This request is the "电影详情" .
     *
     * @param movieDescriptionRequest
     * @return
     */
    @RequestMapping("/MovieDescription")
    public String showMoiveDescription(HttpServletRequest movieDescriptionRequest){

        return "MovieDescription";
    }

    /**
     * This request is the "个人中心" .
     *
     * @return
     */
    @RequestMapping("/Profile")
    public String showProfie() {

        return "Profile";
    }
}
