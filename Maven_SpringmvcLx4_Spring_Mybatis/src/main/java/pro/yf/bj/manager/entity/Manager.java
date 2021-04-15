package pro.yf.bj.manager.entity;

import lombok.Data;

@Data
public class Manager {
   public String manager_nb;
   public String manager_id;
   public String  password;
   public String level;
public String getManager_nb() {
	return manager_nb;
}
public void setManager_nb(String manager_nb) {
	this.manager_nb = manager_nb;
}
public String getManager_id() {
	return manager_id;
}
public void setManager_id(String manager_id) {
	this.manager_id = manager_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
	
	
	}
