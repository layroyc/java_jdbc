package cn.hp.dao;

import cn.hp.model.Student;

public interface StudentDao {
	//�������
	//��¼
	public Student login(String name,String pwd);
	//�޸�����
	public int changepwd(Student s);

}
