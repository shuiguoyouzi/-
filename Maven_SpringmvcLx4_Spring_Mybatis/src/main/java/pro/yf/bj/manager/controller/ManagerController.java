package pro.yf.bj.manager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pro.yf.bj.manager.entity.Manager;
import pro.yf.bj.manager.service.IManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired//自动装配：
	public IManagerService  managerService;
	
	@RequestMapping("/query")
	public String queryClasss(HttpServletRequest request){
		System.out.println("ClasssController:queryClasss()");
		
	     List<Manager> list = managerService.findAll();
		
		System.out.println("--------------->"+list.size());
		
		request.setAttribute("list", list);//将带有数据的list传递给前台的查询展示页面
		
		for (Manager manager : list) {
			System.out.println(manager.getManager_nb()+"\t"+manager.getManager_id()+"\t"+manager.getPassword()+"\t"+manager.getLevel());
		}
		
		return "manager/manager_list";
	}
}
