package cn.hp.model;
/**
 * 实体类
 * 1.给属性提供get/set方法
 * 2.提供有参、无参构造
 * 3.提供toString方法
 *
 */
public class Student {
	int id;
	String name;
	String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Student(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	

}
