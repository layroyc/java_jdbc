package cn.hp.Dao;

import java.util.ArrayList;

import cn.hp.entity.tb_user;

public interface tb_userDao {
	//��¼
	public tb_user login(String u_name,String password);
	 //���
	int insert(tb_user tb_user);
	 //��ѯ
	ArrayList<tb_user> selectAll();
}
