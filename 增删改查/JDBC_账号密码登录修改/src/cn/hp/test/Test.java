package cn.hp.test;

import cn.hp.unit.DBHelper;

public class Test {
	public static void main(String[] args) {
		DBHelper db = new DBHelper();
		System.out.println(db.getConn());
	}

}
