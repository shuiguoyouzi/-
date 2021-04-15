<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>manager模块的FK查询展示页面</title></head>
<a href="${path}/manager.action?method=addpage">进入添加页面</a>
     <table border="1">
         <tr>
           <td>管理员账号</td>
       <td>职工编号</td>
        <td>密码</td>
        <td>级别</td>
        <td>操作</td>
         </tr>
         <#list list as manager >
             <tr>
                <td>${manager. manager_nb}</td>
                <td>${manager.manager_id}</td>
                <td>${manager.password}</td>
                <td>${manager.level}</td>
                 <td>
                 <a href="${path}/manager.action?method=editpage&id=${manager.manager_nb}">修改</a>
                 <a href="${path}/manager.action?method=delete&id=${manager.manager_nb}">删除</a>
                 </td>
             </tr>
         </#list>
     </table>
</body>
</html>