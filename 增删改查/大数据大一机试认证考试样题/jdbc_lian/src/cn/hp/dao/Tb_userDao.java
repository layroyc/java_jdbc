package cn.hp.dao;

import java.util.ArrayList;

import cn.hp.entity.Tb_user;

public interface Tb_userDao {
	//��¼
	public Tb_user login(String u_name,String u_password);
	//���
	int insert(Tb_user tb_user);
	//��ѯ
	ArrayList<Tb_user> selectAll();

}
