package com.movies.test;

import com.movies.dao.IMovieDao;
import com.movies.domain.Movie;
import com.movies.domain.MovieQuery;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MovieTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IMovieDao movieDao;

    @Before
    public void init() throws Exception{
        //读取配置文件，生产字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //获取SqlSession对象
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        //获取dao的代理对象
        movieDao = sqlSession.getMapper(IMovieDao.class);
    }

    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindMovieById(){
        Movie movie = movieDao.findMovieById(48360);
        System.out.println(movie);
    }

    @Test
    public void testFindMovieByName(){
        List<Movie> movies = movieDao.findMovieByName("%Harry Potter%");
        System.out.println(movies.size());
        for(Movie movie:movies){
            System.out.println(movie);
        }
    }

    @Test
    public void testSave(){
        Movie movie = new Movie();
        Date myDate = new Date(1999/03/26);
        movie.setId(1);
        movie.setMovieAct("1234");
        movie.setMovieName("Test");
        movie.setMovieDate(myDate);
        movieDao.saveMovie(movie);
    }

    /**
     * 测试更新操作
     */

    @Test
    public void testUpdate(){
        Movie movie = new Movie();
        Date myDate = new Date(1999/03/26);
        movie.setId(2);
        movie.setMovieAct("12345");
        movie.setMovieName("Test");
        movie.setMovieDate(myDate);
        movieDao.updateMovieByName(movie);
    }

    /**
     * 测试通过电影名称的删除操作
     */
    @Test
    public void testDelete()
    {
        movieDao.deleteMovieByName("Test");
    }

    /**
     * 测试通过id的删除操作
     */
    @Test
    public void testDelete2()
    {
        movieDao.deleteMovieById(1);
    }


    /**
     * 测试按剧情查找且按顺序排序
     */
    @Test
    public void testFindByTypeOnScore(){
        List<Movie> movies = movieDao.findMovieByTypeOnScore("%剧情%");
        System.out.println(movies.size());
        for(Movie movie:movies){
            System.out.println(movie);
        }
    }

    @Test
    public void testFindMovieByCondition(){
        MovieQuery movieQuery = new MovieQuery();
        movieQuery.setShowNumber(50);
        Movie movie = new Movie();
        Date myDate = new Date(1999/03/26);
        movie.setMovieType("剧情");
        movie.setMovieDate(myDate);
        movieQuery.setMovie(movie);
        List<Movie> movies = movieDao.findMovieByCondition(movieQuery);
        System.out.println(movies.size());
        for(Movie myMovie:movies){
            System.out.println(myMovie);
        }
    }
}
