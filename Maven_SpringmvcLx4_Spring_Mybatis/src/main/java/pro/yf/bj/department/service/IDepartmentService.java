package pro.yf.bj.department.service;

import java.util.List;

import pro.yf.bj.department.entity.Department;

public interface IDepartmentService {

	public List<Department> findAll();

	public void save(Department u);

	public Department queryById(String d_id);

	public void eidt(Department department);

	public void delete(String d_id);

}
