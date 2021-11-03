package com.zhaoliwei.util;

import java.sql.*;

public class DBUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    /*
    * 获取连接
    * */
    public static Connection getConnection() throws Exception{
        Connection conn = threadLocal.get();
        if(conn==null){
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","333");
            threadLocal.set(conn);
        }
        return conn;
    }
    /*
    * 关闭资源
    * */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if(conn!=null){
            try {
                conn.close();
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //    开启事务
    public static void beginTransaction(Connection conn) throws Exception{
        if(conn!=null){
            conn.setAutoCommit(false);
        }
    }
    //    提交事务
    public static void commitTransaction(Connection conn) throws Exception{
        if(conn!=null){
            conn.commit();
        }
    }
    //    回滚事务
    public static void rollbackTransaction(Connection conn){
        if(conn!=null){
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //    结束事务
    public static void endTransaction(Connection conn){
        if(conn!=null){
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
