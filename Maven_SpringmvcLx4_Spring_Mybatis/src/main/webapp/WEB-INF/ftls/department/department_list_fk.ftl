<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>manager模块的FK查询展示页面</title></head>
<a href="${path}/department.action?method=addpage">进入添加页面</a>
     <table border="1">
         <tr>
           <td>id</td>
       <td>名字</td>
        <td>密码</td>
        <td>操作</td>
         </tr>
         <#list list as department >
             <tr>
                <td>${department. d_id}</td>
                <td>${department.d_name}</td>
                <td>${department.d_leader}</td>
               
                 <td>
                 <a href="${path}/department.action?method=editpage&id=${department.d_id}">修改</a>
                 <a href="${path}/department.action?method=delete&id=${department.d_id}">删除</a>
                 </td>
             </tr>
         </#list>
     </table>
</body>
</html>