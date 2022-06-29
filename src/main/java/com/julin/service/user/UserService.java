package com.julin.service.user;

import com.julin.pojo.User;

public interface UserService {
    //用户登录
    public User login (String userCode, String password);
}
