package com.zhaoliwei.controller;

import com.zhaoliwei.service.LoginService;
import com.zhaoliwei.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register1Servlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean flag = loginService.register(username,password);
        if(flag){
            request.setAttribute("register5","注册成功，请登录");
            request.getRequestDispatcher("/reandlo.jsp").forward(request,response);

        }
    }
}
