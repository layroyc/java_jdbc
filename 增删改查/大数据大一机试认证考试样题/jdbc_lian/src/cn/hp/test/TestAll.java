package cn.hp.test;
import java.util.ArrayList;

import cn.hp.dao.Tb_userDao;
import cn.hp.dao.Tb_userDaoImpl;
import cn.hp.entity.Tb_user;

public class TestAll {
	public static void main(String[] args) {
		//查询全部
		Tb_userDao tb = new Tb_userDaoImpl();
		ArrayList<Tb_user> list = tb.selectAll();
		for (Tb_user tb_user : list) {
			System.out.println(tb_user);
		}
//		//新增
//		Tb_userDao tb = new Tb_userDaoImpl();
//		Tb_user tb_user = new Tb_user("隶书","123","19");
//		System.out.println(tb_user);
//        int count =tb.insert(tb_user);
//		System.out.println(count);	
	}

}
