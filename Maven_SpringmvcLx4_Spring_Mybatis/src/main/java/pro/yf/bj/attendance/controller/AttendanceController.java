package pro.yf.bj.attendance.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import pro.yf.bj.attendance.entity.Attendance;
import pro.yf.bj.attendance.service.IAttendanceService;
import pro.yf.bj.user.entity.User;
import pro.yf.bj.utils.RequestUtils;
import pro.yf.bj.utils.ResponseUtils;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
	@Autowired
	public IAttendanceService  attendanceService;
	
	/*
	 * 查询全部*/
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/queryToJson")
	public void queryUserToJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("queryattendance()");
		if (!request.getMethod().equals("GET")) {
			return;
		}
		Map<String, Object> result = new HashMap<String, Object>();
		String retStr = "";

		List<Attendance> list = attendanceService.findAll();
		System.out.println("--------------->" + list.size());

		request.setAttribute("list", list);

		for (Attendance attendance : list) {
			System.out.println(
			attendance.getAid() + "\t" + attendance.getAxueli() + "\t" + attendance.getAlizhi() + "\t" + attendance.getApos());
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
	
	//删除
	@ResponseBody//将目标方法的返回值自动转换成json格式，然后返回给前端,但是在版本比较低的浏览器上是不能直接显示的
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	@CrossOrigin
	public void  del(HttpServletRequest request,HttpServletResponse response ,String aid) throws IOException{
		System.out.println("接收到请求");
		try {

			Map<String, Object> result = new HashMap<String, Object>();
			System.out.println("===============>"+aid);
			System.out.println(aid);
			Attendance attendance=new Attendance("");
			attendance.setAid(aid);
			this.attendanceService.del(attendance);
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
