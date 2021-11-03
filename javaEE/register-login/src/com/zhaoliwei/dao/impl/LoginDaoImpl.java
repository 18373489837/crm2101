package com.zhaoliwei.dao.impl;

import com.zhaoliwei.dao.LoginDao;
import com.zhaoliwei.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {
    /*
    * 登录验证
    * */
    @Override
    public int loginDa(String username,String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "select count(*) as totalCount from `register-login` where username=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                result = rs.getInt("totalCount");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("登录错误");
        }finally {
            DBUtil.close(null,ps,null);
        }
        return result;
    }
    /*
    * 修改密码
    * */
    @Override
    public int modification1(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "update `register-login` set password = ? where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,username);
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改失败");
        }finally {
            DBUtil.close(null,ps,null);
        }
        return count;
    }
    /*
    * 注册
    * */
    @Override
    public int register1(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into `register-login`(username,password) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("注册失败，用户已经存在");
        }finally {
            DBUtil.close(null,ps,null);
        }
        return count;
    }
}
