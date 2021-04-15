package pro.yf.bj.user.entity;

/**
 * 
 @desc User模块的实体类
 * @author 云帆大师 微信/QQ:909904682
 * @time 2017-8-15
 * 
 */
public class User {


    
	public String id;
	public String age;
	public String phone;
	public String jf;
	public String address;
	
	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getJf() {
		return jf;
	}


	public void setJf(String jf) {
		this.jf = jf;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}
	public String name;
	public String sex;
	public User() {
	}


	public User(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public User(String id, String name) {
		this.id = id;
		this.name = name;
		
	}


	


	

}
