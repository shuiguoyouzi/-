package pro.yf.bj.wages.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import pro.yf.bj.department.entity.Department;
import pro.yf.bj.utils.RequestUtils;
import pro.yf.bj.utils.ResponseUtils;
import pro.yf.bj.wages.entity.Wages;
import pro.yf.bj.wages.service.IWagesService;

@Controller
@RequestMapping("/wages")
public class WagesrController {

	@Autowired // 自动装配：
	public IWagesService wagesService;

	@CrossOrigin
	// @RequestMapping("/query")
	@ResponseBody // 将目标方法的返回值自动转换成json格式，然后返回给前端,但是在版本比较低的浏览器上是不能直接显示的
	@RequestMapping(value = "/queryToJson", method = RequestMethod.GET)
	public void queryUserToJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("queryUserToJson()");
		if (!request.getMethod().equals("GET")) {
			return;
		}
		Map<String, Object> result = new HashMap<String, Object>();
		String retStr = "";

		List<Wages> list = wagesService.findAll();
		System.out.println("--------------->" + list.size());

		request.setAttribute("list", list);

		for (Wages wages : list) {
			System.out.println(
			wages.getWid() + "\t" + wages.getWgongzi() + "\t" + wages.getWchufa() + "\t" + wages.getWtime());
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(list);
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		ObjectMapper om = new ObjectMapper();
		if (retStr != null) {
			result.put("code", 0);
			result.put("data", list);
		}

		try {
			retStr = om.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseUtils.writeResponse(response, retStr);
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
		
		String wid = UUID.randomUUID().toString(); //生成 id
		
		Wages wages = new Wages(wid);
		
		System.out.println("add -> " + wid);
		System.out.println(rdata);
		
		try {
			
			wages.setWgongzi((String)rdata.get("wgongzi"));
			wages.setWchufa((String)rdata.get("wchufa"));
			wages.setWtime((String)rdata.get("wtime"));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		System.out.println(wages);
		
		wagesService.save(wages);

		ObjectMapper om = new ObjectMapper();

		if (result != null) {
			result.put("code", 0);
		}
		
		ResponseUtils.writeResponse(response, om.writeValueAsString(result));
	}
	//删除
	@ResponseBody//将目标方法的返回值自动转换成json格式，然后返回给前端,但是在版本比较低的浏览器上是不能直接显示的
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	@CrossOrigin
	public void  del(HttpServletRequest request,HttpServletResponse response ,String wid) throws IOException{
		System.out.println("接收到请求");
		try {

			Map<String, Object> result = new HashMap<String, Object>();
			System.out.println("===============>"+wid);
			System.out.println(wid);
			Wages wages=new Wages("");
			wages.setWid(wid);
			this.wagesService.del(wages);
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
}
