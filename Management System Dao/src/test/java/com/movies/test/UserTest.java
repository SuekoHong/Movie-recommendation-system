package com.movies.test;

import com.movies.dao.IUserDao;
import com.movies.domain.User;
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

public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        //读取配置文件，生产字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //获取SqlSession对象
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        //获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        //查询所有方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testSave(){
        User user = new User();
        Date myDate = new Date(1999/03/26);
        user.setUserBirthday(myDate);
        user.setUserEmail("123@123.com");
        user.setUserGender("男");
        user.setUserName("Test");
        user.setUserTel("1234");
        user.setUserPassword("2344656");
        userDao.saveUser(user);
    }

    /**
     * 测试更新操作
     */

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserTel("1234");
        Date myDate = new Date(1999/03/26);
        user.setUserBirthday(myDate);
        user.setUserEmail("123@1234.com");
        user.setUserGender("女");
        user.setUserName("Test1");
        user.setUserPassword("2344656");
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete()
    {
        userDao.deleteUser("1234");
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%雪%");
        for(User user:users){
            System.out.println(user);
        }
    }
}
