<%@ page import="com.zhaoliwei.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 11848
  Date: 2021/10/8
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%
User user = (User)request.getAttribute("user");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-image: url(1001.jpg);background-size: 1300px 650px;background-repeat: no-repeat">
<div style="height: 350px;width: 350px;margin: auto;margin-top: 170px;">
    <h3 style="position: absolute;margin-left: 155px;font-size: 25px">登录成功</h3>
    <form action="/register_login/modification">
        <table style="margin-left: 50px;position: absolute;margin-top: 100px;" cellpadding="8px">
            <tr>
                <td>用&nbsp户&nbsp名</td>
                <td><input type="text" name="username" style="border-radius: 5px;height: 20px" value="<%=user.getUsername()%>" readonly></td>
            </tr>
            <tr>
                <td>密&nbsp码</td>
                <td><input type="text" name="password" style="border-radius: 5px;height: 20px" value="<%=user.getPassword()%>" id="password"></td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="修改密码" style="margin-left: 70px">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
