package com.zhaoliwei.controller;

import com.zhaoliwei.bean.User;
import com.zhaoliwei.service.LoginService;
import com.zhaoliwei.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
        private  LoginService loginService = new LoginServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GB18030");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int count = loginService.loginSe(username,password);
        if(count == 1){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.setAttribute("user",user);
            request.getRequestDispatcher("/number.jsp").forward(request,response);
        }else if(count == 0){
            request.setAttribute("result","用户不存在");
           request.getRequestDispatcher("/reandlo.jsp").forward(request,response);
        }
    }
}
