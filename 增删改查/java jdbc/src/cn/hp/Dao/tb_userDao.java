package cn.hp.Dao;

import java.util.ArrayList;

import cn.hp.entity.tb_user;

public interface tb_userDao {
	//µÇÂ¼
	public tb_user login(String u_name,String password);
	 //Ìí¼Ó
	int insert(tb_user tb_user);
	 //²éÑ¯
	ArrayList<tb_user> selectAll();
}
