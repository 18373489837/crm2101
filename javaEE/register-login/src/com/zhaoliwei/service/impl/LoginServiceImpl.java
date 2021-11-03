package com.zhaoliwei.service.impl;

import com.zhaoliwei.dao.LoginDao;
import com.zhaoliwei.dao.impl.LoginDaoImpl;
import com.zhaoliwei.service.LoginService;
import com.zhaoliwei.util.DBUtil;

import java.sql.Connection;

public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao = new LoginDaoImpl();
    /*
    * 登录验证
    * */
    @Override
    public int loginSe(String username,String password) {
        Connection conn = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            DBUtil.beginTransaction(conn);
            count = loginDao.loginDa(username,password);
            DBUtil.commitTransaction(conn);
        } catch (Exception e) {
            e.printStackTrace();
           DBUtil.rollbackTransaction(conn);
        }finally {
            DBUtil.endTransaction(conn);
            DBUtil.close(conn,null,null);

        }
        return count;
    }
    /*
    * 修改密码
    * */
    @Override
    public boolean modification(String username, String password) {
        Connection conn = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            DBUtil.beginTransaction(conn);
            count = loginDao.modification1(username,password);
            DBUtil.commitTransaction(conn);
        } catch (Exception e) {
            e.printStackTrace();
            DBUtil.rollbackTransaction(conn);
        }finally {
            DBUtil.endTransaction(conn);
            DBUtil.close(conn,null,null);
        }
        return count==1;
    }
    /*
    * 注册
    * */
    @Override
    public boolean register(String username, String password) {
        Connection conn = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            DBUtil.beginTransaction(conn);
            count = loginDao.register1(username,password);
            DBUtil.commitTransaction(conn);
        } catch (Exception e) {
            e.printStackTrace();
            DBUtil.rollbackTransaction(conn);
        }finally {
            DBUtil.endTransaction(conn);
            DBUtil.close(conn,null,null);
        }
        return count==1;
    }
}
