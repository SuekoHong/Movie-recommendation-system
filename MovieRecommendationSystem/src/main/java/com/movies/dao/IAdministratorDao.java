package com.movies.dao;

import com.movies.domain.Administrator;

import java.util.List;

public interface IAdministratorDao {
    /**
     * 查询所有信息
     * @return
     */
    List<Administrator> findAll();

    /**
     * 保存管理员
     * @param Administrator
     */
    void saveAdministrator(Administrator administrator);

    /**
     * 删除管理员
     * @param Administrator
     */
    void deleteAdministrator(String administratorTel);

    /**
     * 更新管理员
     * @param Administrator
     */
    void updateAdministrator(Administrator administrator);

    /**
     *根据名称模糊查询
     * @param name
     * @return
     */
    List<Administrator> findByName(String name);
}
