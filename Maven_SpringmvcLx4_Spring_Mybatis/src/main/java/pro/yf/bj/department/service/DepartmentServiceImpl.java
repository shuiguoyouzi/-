package pro.yf.bj.department.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pro.yf.bj.department.dao.DepartmentMapper;
import pro.yf.bj.department.entity.Department;

@Transactional
@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService{
	@Autowired
    private DepartmentMapper departmentMapper;
	public List<Department> findAll() {
		
		return departmentMapper.fiandAll();
	}
	public void save(Department u) {
		 u.setId(UUID.randomUUID().toString());
		 departmentMapper.save(u);
		
	}
	public Department queryById(String d_id) {
		
		return departmentMapper.queryById(d_id);
	}
	public void eidt(Department department) {
		departmentMapper.edit(department);
		
	}
	public void delete(String d_id) {
		departmentMapper.delete(d_id);	
		
	}

}
