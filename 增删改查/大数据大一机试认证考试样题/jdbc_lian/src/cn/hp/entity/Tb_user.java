package cn.hp.entity;
/**
 *  µÃÂ¿‡
 * @author Administrator
 *
 */
public class Tb_user {
	int u_id;
	String u_name; 
	String u_password;
	String u_age;
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
	public Tb_user(int u_id, String u_name, String u_password, String u_age) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_age = u_age;
	}
	
	public Tb_user(String u_name, String u_password, String u_age) {
		super();
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_age = u_age;
	}
	public Tb_user(int u_id, String u_name, String u_password) {
		super();
	}
	public Tb_user(String u_name, String u_password) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tb_user [u_id=" + u_id + ", u_name=" + u_name + ", u_password="
				+ u_password + ", u_age=" + u_age + "]";
	}
	
	
	

}
