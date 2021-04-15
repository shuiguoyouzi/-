package pro.yf.bj.user.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import pro.yf.bj.user.dao.UserMapper;
import pro.yf.bj.user.entity.User;

@Transactional
@Service("userService")//该注解的意思为标识出当前的类/模块是一个M层，且当前这个Service的值为userService
public class UserServiceImpl   implements   IUserService{

	@Autowired
	private UserMapper userMapper;
	
	
	
	public List<User> findAll() {
		
		return userMapper.fiandAll();
	}
//删除
	@Override
	public void del(User user) {
		
		userMapper.delete(user);
	}


	public void save(User u) {
          userMapper.save(u);		
	}

	@Override
	public void update(User user) {
		 userMapper.update(user);
		
	}















}
