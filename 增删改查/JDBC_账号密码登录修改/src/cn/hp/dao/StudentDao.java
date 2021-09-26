package cn.hp.dao;

import cn.hp.model.Student;

public interface StudentDao {
	//定义规则
	//登录
	public Student login(String name,String pwd);
	//修改密码
	public int changepwd(Student s);

}
