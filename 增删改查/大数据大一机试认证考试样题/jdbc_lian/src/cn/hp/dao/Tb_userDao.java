package cn.hp.dao;

import java.util.ArrayList;

import cn.hp.entity.Tb_user;

public interface Tb_userDao {
	//µÇÂ¼
	public Tb_user login(String u_name,String u_password);
	//Ìí¼Ó
	int insert(Tb_user tb_user);
	//²éÑ¯
	ArrayList<Tb_user> selectAll();

}
