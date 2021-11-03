
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>从一个接收jsp到另一个jsp</title>
  </head>
  <body>
 <form action="show.jsp" method="post">
     <table>
         <tr>
             <td>姓名</td>
             <td><input type="text" name="name"></td>
         </tr>
         <tr>
             <td>年龄</td>
             <td><input type="text" name="age"></td>
         </tr>
         <tr>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <td><input type="submit" value="提交"></td>
         </tr>
     </table>
 </form>
  </body>
</html>
