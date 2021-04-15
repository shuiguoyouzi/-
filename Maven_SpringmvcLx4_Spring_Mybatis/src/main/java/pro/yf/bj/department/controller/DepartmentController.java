package pro.yf.bj.department.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import pro.yf.bj.department.entity.Department;
import pro.yf.bj.department.service.IDepartmentService;
import pro.yf.bj.user.entity.User;
import pro.yf.bj.utils.ResponseUtils;

@Controller
@RequestMapping("/department")
public class DepartmentController {
  @Autowired
   public IDepartmentService departmentService;
  // HttpSession session;
   @RequestMapping("/query")
   public String queryDepartment(HttpServletRequest request){
		System.out.println("DepartmentController:queryDepartment()");	
	    List<Department> list = departmentService.findAll();
		
		System.out.println("--------------->"+list.size());
		
		request.setAttribute("list", list);//将带有数据的list传递给前台的查询展示页面
		
		for (Department department : list) {
		 System.out.println(department);		
     }
		return "department/department_list";
		
}/**
@RequestMapping("/cleasSession")
   public void clearSession(SessionStatus  status)
   {
   	  System.out.println("clearSession()");
   	  status.setComplete();//清除当前处理器通过@SessionAttribute注册的session属性
   }
@ResponseBody//将目标方法的返回值自动转换成json格式，然后返回给前端,但是在版本比较低的浏览器上是不能直接显示的
@RequestMapping(value="/queryToJson",method = RequestMethod.GET)
public void  queryUserToJson(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("queryUserToJson()");
		if (!request.getMethod().equals("GET")) {
			return;
		}
		Map<String, Object> result = new HashMap<String, Object>();
		String retStr = "";
		
		 //response.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8040/BootStrapStudy/");
	     List<Department> list = departmentService.findAll();
		System.out.println("--------------->"+list.size());
	
		
		request.setAttribute("list", list);
		
		for (Department department : list) {
			System.out.println(department.getD_id()+"\t"+department.getD_name()+"\t"+department.getD_leader());
		}
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		ObjectMapper objectMapper=new ObjectMapper();
		String json = objectMapper.writeValueAsString(list);
		PrintWriter out = response.getWriter();
	    response.setCharacterEncoding("UTF-8");
		ObjectMapper om = new ObjectMapper();
	    if (retStr!= null) {
	    	result.put("code",0);
	    	result.put("data", list);
	 		}
		
	    try {
			retStr = om.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseUtils.writeResponse(response,retStr);
	}
	
	*/
//@ResponseBody
//@RequestMapping("/sendJson")
/**
 *@RequestBody:将Json--->Pojo==entity==实体类对象，就本例子而言是User对象 
 *@ResponseBody：将pojo/其他对象(list)转为json
 */
/*public  Department getJsonFromJsp(@RequestBody Department department )
{
	
	System.out.println("在Controller中获取到从前台jsp页面传递过来的json格式的数据在@RequestBody的作用下转变为pojo对象");
	System.out.println("-------------->"+department);
	return department;//然后在@ResponseBody的作用下再返回到前台页面上
	
 }*/
@RequestMapping("/addPage")	
public String addPage()
{
	System.out.println("-------进入department模块的添加页面------》");
    return "department/department_add";
}	
 @RequestMapping("/add")	
   public String add(Department u,HttpServletRequest  request)
  {
   System.out.println("-------add()------》");


   departmentService.save(u);
   return "redirect:/department/query";
}
 @RequestMapping("/editPage")	
 public ModelAndView editpage(String d_id)
 {
 	ModelAndView modelAndView = new ModelAndView();
 	Department department = departmentService.queryById(d_id);
 	modelAndView.addObject("department",department);
 	modelAndView.setViewName("department/department_edit");
 	return modelAndView;
 }	
 @RequestMapping("/edit")	
 public String edit(Department department)
 {
 	departmentService.eidt(department);
 	return "redirect:/department/query.action";
 }	

 @RequestMapping("delete")
 public String delete(String d_id) {
 	departmentService.delete(d_id);
 	return"redirect:/department/query.action";
 }
}	