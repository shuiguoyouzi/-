package pro.yf.bj.attendance.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import pro.yf.bj.attendance.entity.Attendance;
import pro.yf.bj.user.dao.UserMapper;
import pro.yf.bj.user.entity.User;

import java.util.List; 

@Repository("attendanceMapper")
public interface AttendanceMapper extends BaseMapper<Attendance>{
//查询
	@Select("select * from attendance")

	public List<Attendance> fiandAll();
	public void save(Attendance u);
	
	
	//删除
	@Delete("delete from attendance where aid = #{aid}")
	public void delete(Attendance attendance) ;
	
	//@Update("update attendance set name=#{name},sex=#{sex},age=#{age},phone=#{phone},address=#{address},jf=#{jf} where id=#{id}")
	//public void update(User user);
	

		
	

}
