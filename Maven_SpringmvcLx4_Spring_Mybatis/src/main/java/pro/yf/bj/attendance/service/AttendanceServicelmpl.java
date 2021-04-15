package pro.yf.bj.attendance.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pro.yf.bj.attendance.dao.AttendanceMapper;
import pro.yf.bj.attendance.entity.Attendance;
import pro.yf.bj.user.entity.User;
import pro.yf.bj.wages.dao.WagesMapper;
import pro.yf.bj.wages.entity.Wages;

@Transactional
@Service("attendanceService")//该注解的意思为标识出当前的类/模块是一个M层，且当前这个Service的值为userService
public  class AttendanceServicelmpl implements IAttendanceService {
	
	/*@Autowired//自动装配：一个名字叫userService的bean,从Springmvc框架扫描到的@Service注解中去寻找
	private AttendanceMapper  attendanceMapper;
	public List<Attendance> fiandAll() {
		System.out.println("执行");
		return attendanceMapper.fiandAll();
	}
	public List<Attendance> findAll() {
		// TODO Auto-generated method stub
		return null;
	}*/
	@Autowired
	private AttendanceMapper attendanceMapper;
	public List<Attendance> findAll() {
		System.out.println("执行");
		return attendanceMapper.fiandAll();
	}
	public void save(Attendance u) {
		 u.setAid(UUID.randomUUID().toString());
		 attendanceMapper.save(u);
		
	}
	public List<Attendance> queryAll() {
		return attendanceMapper.fiandAll();
	}
//删除
	public void del(Attendance attendance) {
		attendanceMapper.delete(attendance);
		
	}




}
