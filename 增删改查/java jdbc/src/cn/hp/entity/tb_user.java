package cn.hp.entity;

public class tb_user {
	//实体类 
	//数据表有几个字段 我们就要写几个属性
	//1.写对应的属性
	  int u_id;
	  String u_name;
	  String u_password;
	  String u_age;
	//2.利用开发工具 自动生成get,set方法 进行封装
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_age() {
		return u_age;
	}
	public void setU_age(String u_age) {
		this.u_age = u_age;
	}
	//3.构造方法 自动生成
	public tb_user(int u_id, String u_name, String u_password, String u_age) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_age = u_age;
	}
	
	public tb_user(String u_name, String u_password, String u_age) {
		super();
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_age = u_age;
	}
	public tb_user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public tb_user(String u_name, String u_password){
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "tb_user [u_id=" + u_id + ", u_name=" + u_name + ", u_password="
				+ u_password + ", u_age=" + u_age + "]";
	}
	
	
	  
	  
}
