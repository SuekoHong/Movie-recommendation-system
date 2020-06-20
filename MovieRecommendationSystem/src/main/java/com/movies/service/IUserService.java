package com.movies.service;

import com.movies.dao.IUserDao;
import com.movies.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This interface is service layer with user.
 * @author sueko
 * @version 1.0
 */

public interface IUserService {

    /**
     *This interface is for new user register
     * @param user
     * @return
     */
    public String userRegister(User user);

    /**
     * This interface is for user log in
     * @param user
     * @return
     */
    public boolean userLogIn(User user);

    /**
     * This interface is for user log out
     * @param user
     * @return
     */
    public boolean userLogOut(User user);

    /**
     * This interface is for user changing Password
     * @param user
     * @return
     */
    public boolean userChangePassword(User user);

    /**
     * This interface is for user changing name
     * @param user
     * @return
     */
    public boolean userChangeName(User user);

    /**
     *
     */
    public void findAll();
}
