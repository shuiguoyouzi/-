<%@page import="pro.yf.bj.department.entity.Department"   isELIgnored="false"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department模块的查询</title>
</head>
<body>

      <form action=""  method="post">
       <table  border="5px"  bordercolor="green" align="center">
       <tr>
       <td>id</td>
       <td>名字</td>
       <td>密码</td>
       <td>操作</td>
       </tr>

       <c:forEach  items="${list}"  var="department"   varStatus="i">
     
       <tr>
       <td>${department.id}</td>
       <td>${department.dname}</td>
       <td>${department.dleader}</td>
         <td>
             <a href="<%=request.getContextPath()%>/department/addPage.action">添加</a>
             <a href="<%=request.getContextPath()%>/department/editPage.action?id=${department.id}">修改</a>
             <a href="<%=request.getContextPath()%>/department/delete.action?id=${department.id}">删除</a>
           </td>
       </tr>
       </c:forEach>   
       </table>
  
      </form>




</body>
</html>
