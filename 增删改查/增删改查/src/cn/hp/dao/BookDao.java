package cn.hp.dao;

import java.util.ArrayList;

import cn.hp.entity.Book;


public interface BookDao {
	//��¼
//	Book login(String bname,String bauthor);
	//���
	int insert(Book book);
	//��ѯ
	ArrayList<Book> selectAll();
	//�������Ʋ�ѯ
	Book selectbname(String bname);
	//�޸�
//	int update(Book book);
	Book selectbooks (int id);
	int update(Book b,int id);
	//ɾ��
    int delete(int id);
	
}
