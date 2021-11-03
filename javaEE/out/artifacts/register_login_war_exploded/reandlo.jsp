<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String rel = (String)request.getAttribute("result");
    String rel2 = (String)request.getAttribute("result2");
    String rel3 = (String)request.getAttribute("register5");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录/注册</title>
    <script>
        function result() {
                <%
            if(rel!=null){
                %>
            alert("<%=rel%>");
           <%
            }
           %>
            <%
         if(rel2!=null){
             %>
            alert("<%=rel2%>");
            <%
             }
            %>
            <%
         if(rel3!=null){
             %>
            alert("<%=rel3%>");
            <%
             }
            %>
            }

            function login1() {
            var flag = x()
                if(flag){
                    document.getElementById("reAndLo").action="/register_login/login";
                    document.forms[0].submit()
                }

            }

            function register1() {
                var flag = x()
                if (flag) {
                    document.getElementById("reAndLo").action = "/register_login/register";
                    document.forms[0].submit()
                }
            }
            function x() {
                var username = document.getElementById("username");
                var password = document.getElementById("password");
                if((username.value)==""){
                    alert("用户名不能为空");
                    username.focus();
                    return false;
                }
                if((password.value)==""){
                    alert("密码不能为空");
                    username.focus();
                    return false;
                }
                return true;
            }
    </script>
</head>
<body style="background-image: url(1001.jpg);background-size: 1300px 650px;background-repeat: no-repeat" onload="result()">
<div style="height: 350px;width: 350px;margin: auto;margin-top: 170px;">
    <h3 style="position: absolute;margin-left: 155px;font-size: 25px">登录/注册</h3>
    <form id="reAndLo">
<table style="margin-left: 50px;position: absolute;margin-top: 100px;" cellpadding="8px">
    <tr>
        <td>用&nbsp户&nbsp名</td>
        <td><input type="text" name="username" style="border-radius: 5px;height: 17px" id="username"></td>
    </tr>
    <tr>
        <td>密&nbsp码</td>
        <td><input type="password" name="password" style="border-radius: 5px;height: 17px" id="password"></td>
    </tr>
    <tr align="center">
        <td colspan="2">
            <input type="submit" value="登录" style="margin-left: 65px;border-radius: 3px" onclick="login1()">
            <input type="submit" value="注册" style="margin-left: 30px;border-radius: 3px" onclick="register1()">
        </td>
    </tr>
</table>
    </form>
</div>
</body>
</html>