package pro.yf.bj.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pro.yf.bj.manager.dao.ManagerMapper;
import pro.yf.bj.manager.entity.Manager;
@Transactional
@Service("managerService")
public class ManagerServiceImpl implements IManagerService{
	@Autowired
	private ManagerMapper managerMapper;
	public List<Manager> findAll() {
		return managerMapper.fiandAll();
	}

}
