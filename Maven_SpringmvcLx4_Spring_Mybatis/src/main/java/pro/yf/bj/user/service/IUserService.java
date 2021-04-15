package pro.yf.bj.user.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import pro.yf.bj.user.entity.User;

public interface IUserService {

	public List<User>  findAll();
	
	
	public void del(User user);
	public void save(User u);
	public void update(User user);
	

	

	

}
