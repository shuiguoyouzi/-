package pro.yf.bj.attendance.entity;

import lombok.Data;


public class Attendance {
	public String aid;
	public String axueli;
	public String alizhi;
	public String apos;

	public Attendance(String aid2) {
		// TODO Auto-generated constructor stub
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAxueli() {
		return axueli;
	}
	public void setAxueli(String axueli) {
		this.axueli = axueli;
	}
	public String getAlizhi() {
		return alizhi;
	}
	public void setAlizhi(String alizhi) {
		this.alizhi = alizhi;
	}
	public String getApos() {
		return apos;
	}
	public void setApos(String apos) {
		this.apos = apos;
	}
	

}
