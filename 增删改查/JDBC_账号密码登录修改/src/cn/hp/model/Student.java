package cn.hp.model;
/**
 * ʵ����
 * 1.�������ṩget/set����
 * 2.�ṩ�вΡ��޲ι���
 * 3.�ṩtoString����
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
