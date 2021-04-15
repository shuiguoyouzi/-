package pro.yf.bj.manager.dao;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import pro.yf.bj.manager.entity.Manager;


@Repository("managerMapper")
public interface ManagerMapper {
	@Select("select * from manager")
	public List<Manager>fiandAll();
}
