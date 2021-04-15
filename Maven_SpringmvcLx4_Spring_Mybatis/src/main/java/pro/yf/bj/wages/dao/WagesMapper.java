package pro.yf.bj.wages.dao;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import pro.yf.bj.user.entity.User;
import pro.yf.bj.wages.entity.Wages;


@Repository("wagesMapper")
public interface WagesMapper extends BaseMapper<Wages> {
	@Select("select * from wages")
	public List<Wages> fiandAll();
	
	@Insert("insert into wages (wid,wgongzi,wchufa,wtime) values (#{wid},#{wgongzi},#{wchufa},#{wtime})")
	public void save(Wages u);
	//删除
	@Delete ("delete from wages where wid = #{wid}")
	public void delete(Wages wages);
}
