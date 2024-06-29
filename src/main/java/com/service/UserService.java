package com.service;

import com.entity.User;
import com.util.DataSourceUtil;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static List<User> getUsers(){
        List<User> userList = new ArrayList<>();
        String sql = "select * from User";
        //在try（内部打开的文件可以自动关闭，因此取数据库内容放在这里面）
        try (Connection conn = DataSourceUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                User user =new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setInsertTime(rs.getObject("insert_time", LocalDateTime.class));
                user.setUpdateTime(rs.getObject("update_time", LocalDateTime.class));
                userList.add(user);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);

        }
        return userList;
    }
    public static void updateUser(int id,String name){
        String sql = "update  User u set u.name = ? where u.id =?";
        try (Connection conn = DataSourceUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1,name);
            ps.setInt(2,id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);

        }
    }
    public static User getUser( int id){
        User user = new User();
        String sql ="select * from User u where u.id = ?";
        try (Connection conn = DataSourceUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                rs.next();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setInsertTime(rs.getObject("insert_time", LocalDateTime.class));
                user.setUpdateTime(rs.getObject("update_time", LocalDateTime.class));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
