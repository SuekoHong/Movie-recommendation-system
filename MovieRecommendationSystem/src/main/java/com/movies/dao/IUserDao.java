package com.movies.dao;

import com.movies.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface is kinds of operations about user.The implement write on the IUserDaoImpl.xml.
 * @author sueko
 * @version 1.0
 */

@Repository
public interface IUserDao {
    /**
     * 查询所有信息
     * @return
     */
    List<User> findAll();

    /**
     * 保存管理员
     * @param user
     */
    void saveUser(User user);

    /**
     * 删除管理员
     * @param user
     */
    void deleteUser(String userTel);

    /**
     * 更新管理员
     * @param user
     */
    void updateUser(User user);

    /**
     *根据名称模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);
}
