package com.julin.dao.User;

import com.julin.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    //得到登录的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;
}
