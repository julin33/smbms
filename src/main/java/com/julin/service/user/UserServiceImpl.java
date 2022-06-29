package com.julin.service.user;

import com.julin.dao.BaseDao;
import com.julin.dao.User.UserDao;
import com.julin.dao.User.UserDaoImpl;
import com.julin.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    //业务层都会调Dao层，所以我们要引入Dao层
    private UserDao userDao;
    public UserServiceImpl (){
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;


        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "123456");
        System.out.println(admin.getUserPassword());
    }
}
