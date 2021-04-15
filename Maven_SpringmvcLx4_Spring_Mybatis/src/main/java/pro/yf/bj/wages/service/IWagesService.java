package pro.yf.bj.wages.service;

import java.util.List;

import pro.yf.bj.department.entity.Department;
import pro.yf.bj.wages.entity.Wages;

public interface IWagesService {

	List<Wages> findAll();

	void save(Wages u);

	List<Wages> queryAll();

	void del(Wages wages);

	//List<Department> findAll();

}
