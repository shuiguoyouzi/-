package pro.yf.bj.department.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import pro.yf.bj.department.entity.Department;
import pro.yf.bj.manager.entity.Manager;

// extends BaseMapper<Department>
@Repository("departmentMapper")
public interface DepartmentMapper {
	@Select("select * from department")
	public List<Department> fiandAll();
	@Insert("insert into department (d_id,d_name,d_leader) values (#{d_id},#{d_name},#{d_leader})")
	public void save(Department d);
	@Select("select * from department where id=#{d_id}")
	public Department queryById(String d_id);
	@Update("update department set d_id=#{d_id} ,d_name=#{d_name},d_leader=#{d_leader} where id=#{d_id}")
	public void edit(Department department);
	@Delete("delete from department where id = #{d_id}")
	public void delete(String d_id);
}
