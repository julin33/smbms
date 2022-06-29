package com.julin.dao.User;

import com.julin.dao.BaseDao;
import com.julin.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public User getLoginUser(Connection connection, String userCode) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};


            rs = BaseDao.execute(connection,pstm,rs,sql,params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("Gender"));
                user.setBirthday(rs.getDate("Birthday"));
                user.setPhone(rs.getString("Phone"));
                user.setAddress(rs.getString("Address"));
                user.setUserRole(rs.getInt("UserRole"));
                user.setCreatedBy(rs.getInt("CreatedBy"));
                user.setCreationDate(rs.getDate("CreationDate"));
                user.setModifyBy(rs.getInt("ModifyBy"));
                user.setModifyDate(rs.getDate("ModifyDate"));
            }

            BaseDao.closeResource(null,pstm,rs);

        }
        return user;


    }
}
