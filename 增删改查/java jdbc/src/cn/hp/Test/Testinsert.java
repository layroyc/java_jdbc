package cn.hp.Test;

import cn.hp.Dao.tb_userDao;
import cn.hp.Dao.tb_userDaoImpl;
import cn.hp.entity.tb_user;

public class Testinsert {
public static void main(String[] args) {
	
	tb_userDao tb = new tb_userDaoImpl();
	tb_user tb1 = new tb_user("ÀîËÄ","123","19");
    int i =tb.insert(tb1);
	System.out.println(i);

}
}
