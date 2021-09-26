package cn.hp.dao;

import java.util.ArrayList;

import cn.hp.entity.Book;


public interface BookDao {
	//登录
//	Book login(String bname,String bauthor);
	//添加
	int insert(Book book);
	//查询
	ArrayList<Book> selectAll();
	//输入名称查询
	Book selectbname(String bname);
	//修改
//	int update(Book book);
	Book selectbooks (int id);
	int update(Book b,int id);
	//删除
    int delete(int id);
	
}
