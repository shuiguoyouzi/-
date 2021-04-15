package pro.yf.bj.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import pro.yf.bj.user.entity.User;
import pro.yf.bj.user.service.IUserService;
import pro.yf.bj.utils.RequestUtils;
import pro.yf.bj.utils.ResponseUtils;
import sun.print.resources.serviceui;

/**
 * 
   @desc    User模块的控制器
 * @author  云帆大师 微信/QQ:909904682
 * @time    2017-8-15
 *
 */

@Controller
@RequestMapping("/user")
@SessionAttributes(value={"queryByNameStr"})//将条件查询的值保持在session中
public class UserController {

	@Autowired//自动装配：一个名字叫userService的bean,从Springmvc框架扫描到的@Service注解中去寻找
	public IUserService  userService;
	
	HttpSession session;//因为一会要清空session，所以做成全局的
	
	
	 
	
@ResponseBody	
@RequestMapping("/queryFK")
public List<User> queryFK(HttpServletRequest request,ModelMap map){
	System.out.println("UserController:queryFK()");
	
     List<User> list = userService.findAll();
	
	System.out.println("--------------->"+list.size());
	
	//request.setAttribute("list", list);
	map.addAttribute("list", list);
	String path = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath() + "/";
	map.addAttribute("path", path);
	for (User user : list) {
		System.out.println(user.getId()+"\t"+user.getName());
	}
	
	return list;
}
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
	     List<User> list = userService.findAll();
		System.out.println("--------------->"+list.size());
	
		
		request.setAttribute("list", list);
		
		for (User user : list) {
			System.out.println(user.getId()+"\t"+user.getName());
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
@ResponseBody//将目标方法的返回值自动转换成json格式，然后返回给前端,但是在版本比较低的浏览器上是不能直接显示的
@RequestMapping(value="/add",method = RequestMethod.POST)
@CrossOrigin
public void  add(HttpServletRequest request,HttpServletResponse response) throws IOException{

		
	if (request.getMethod().equals("OPTIONS")) { //处理 预请求
	    ResponseUtils.writeResponse(response,"");
		return;
	}
	
	if (!request.getMethod().equals("POST")) {
		return;
	}
	
	Map<String, Object> rdata = RequestUtils.getRequestMap(request);
	Map<String, Object> result = new LinkedHashMap<String, Object>();
	
	String id = UUID.randomUUID().toString(); //生成 id
	
	User user = new User(id);
	
	System.out.println("add -> " + id);
	System.out.println(rdata);
	
	try {
		user.setName((String)rdata.get("name"));
		user.setSex((String)rdata.get("sex"));
		user.setAge((String)rdata.get("age"));
		user.setPhone((String)rdata.get("phone"));
		user.setAddress((String)rdata.get("address"));
		user.setJf((String)rdata.get("jf"));
	} catch (Exception e) {
		e.printStackTrace();
		return;
	}
	
	
	System.out.println(user);
	
	userService.save(user);

	ObjectMapper om = new ObjectMapper();

	if (result != null) {
		result.put("code", 0);
	}
	
	ResponseUtils.writeResponse(response, om.writeValueAsString(result));
}

@ResponseBody//将目标方法的返回值自动转换成json格式，然后返回给前端,但是在版本比较低的浏览器上是不能直接显示的
@RequestMapping(value="/edit",method = RequestMethod.POST)
@CrossOrigin
public void  edit(HttpServletRequest request,HttpServletResponse response) throws IOException{
	if (request.getMethod().equals("OPTIONS")) { //处理 预请求
	    ResponseUtils.writeResponse(response,"");
		return;
	}
	
	if (!request.getMethod().equals("POST")) {
		return;
	}
	Map<String, Object> rdata = RequestUtils.getRequestMap(request);
	Map<String, Object> result = new LinkedHashMap<String, Object>();
	
	String id = (String)rdata.get("id");
	User user = new User(id);
	
	System.out.println("update -> " + id);
	System.out.println(rdata);
	
	try {
		user.setName((String)rdata.get("name"));
		user.setSex((String)rdata.get("sex"));
		user.setAge((String)rdata.get("age"));
		user.setPhone((String)rdata.get("phone"));
		user.setAddress((String)rdata.get("address"));
		user.setJf((String)rdata.get("jf"));
	} catch (Exception e) {
		e.printStackTrace();
		return;
	}
	
	
	
	userService.update(user);

	ObjectMapper om = new ObjectMapper();

	if (result != null) {
		result.put("code", 0);
	}
	
	ResponseUtils.writeResponse(response, om.writeValueAsString(result));
}




@ResponseBody//将目标方法的返回值自动转换成json格式，然后返回给前端,但是在版本比较低的浏览器上是不能直接显示的
@RequestMapping(value="/del",method = RequestMethod.POST)
@CrossOrigin
public void  del(HttpServletRequest request,HttpServletResponse response) throws IOException{
	System.out.println("接收到请求");
	try {
		if (request.getMethod().equals("OPTIONS")) { //处理 预请求
			System.out.println("22222222222222222222");
		    ResponseUtils.writeResponse(response,"");
			return;
		}
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> rdata = RequestUtils.getRequestMap(request);
		
		String id = (String)rdata.get("id");
		System.out.println(id);
		this.userService.del(new User(id));
		ObjectMapper om = new ObjectMapper();
		String retStr = "";
		if (retStr!= null) {
	    	result.put("code",200);
	 		}
		
	    try {
	    	
			retStr = om.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseUtils.writeResponse(response,retStr);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	

    
    	

	

@ResponseBody
@RequestMapping("/sendJson")
/**
 *@RequestBody:将Json--->Pojo==entity==实体类对象，就本例子而言是User对象 
 *@ResponseBody：将pojo/其他对象(list)转为json
 */
public  User getJsonFromJsp(@RequestBody User user )
{
	
	System.out.println("在Controller中获取到从前台jsp页面传递过来的json格式的数据在@RequestBody的作用下转变为pojo对象");
	System.out.println("-------------->"+user);
	return user;//然后在@ResponseBody的作用下再返回到前台页面上
}	
	

	
	


}
