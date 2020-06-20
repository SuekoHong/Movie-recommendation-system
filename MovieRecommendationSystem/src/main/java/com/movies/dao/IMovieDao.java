package com.movies.dao;

import com.movies.domain.Movie;
import com.movies.domain.MovieQuery;

import java.util.List;

public interface IMovieDao {

    /**
     * 通过电影id精确查找电影信息
     * @param movieName
     * @return
     */
    Movie findMovieById(Integer Id);

    /**
     * 通过电影名称模糊查找电影信息
     * 调用此接口时请在string前后加上%，例如%1%
     * @param name
     * @return
     */
    List<Movie> findMovieByName(String name);

    /**
     * 保存某一部电影
     * @param movie
     */
    void saveMovie(Movie movie);

    /**
     * 更新电影信息
     * @param movie
     */
    void updateMovieByName(Movie movie);

    /**
     * 通过电影名称删除电影
     * @param MovieName
     */
    void deleteMovieByName(String MovieName);

    /**
     * 通过电影id删除电影
     * @param id
     */
    void deleteMovieById(Integer id);

    /**
     * 按高分排序的通过电影类型查找电影
     * 调用此接口时请在string前后加上%，例如%1%
     * @param type
     * @return
     */
    List<Movie> findMovieByTypeOnScore(String type);

    /**
     * 按时间排序的通过电影类型查找电影
     * 调用此接口时请在string前后加上%，例如%1%
     * @param type
     * @return
     */
    List<Movie> findMovieByTypeOnTime(String type);

    /**
     * 根据传入的参数条件
     * @param movieQuery 查询条件
     * @return
     */
    List<Movie> findMovieByCondition(MovieQuery movieQuery);
}
