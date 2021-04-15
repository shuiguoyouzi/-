package pro.yf.bj.attendance.service;

import java.util.List;

import pro.yf.bj.attendance.entity.Attendance;
import pro.yf.bj.user.entity.User;


public interface IAttendanceService {
	List<Attendance> findAll();

	void save(Attendance u);
	
	//删除

	List<Attendance> queryAll();

	void del(Attendance attendance);

	


}
