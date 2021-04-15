package pro.yf.bj.wages.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pro.yf.bj.user.dao.UserMapper;
import pro.yf.bj.wages.dao.WagesMapper;
import pro.yf.bj.wages.entity.Wages;
@Transactional
@Service("wagesService")
public class WagesServiceImpl implements IWagesService{
	@Autowired
	private WagesMapper wagesMapper;
	public List<Wages> findAll() {
		System.out.println("执行");
		return wagesMapper.fiandAll();
	}
	public void save(Wages u) {
		 u.setWid(UUID.randomUUID().toString());
		 wagesMapper.save(u);
		
	}
	public List<Wages> queryAll() {
		return wagesMapper.fiandAll();
	}
	public void del(Wages wages) {
		
		wagesMapper.delete(wages);
	}

}
