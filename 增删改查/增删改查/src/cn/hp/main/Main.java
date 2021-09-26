package cn.hp.main;

import java.util.ArrayList;
import java.util.Scanner;

import cn.hp.dao.BookDao;
import cn.hp.dao.BookDaoImpl;
import cn.hp.entity.Book;
import cn.hp.entity.User;

public class Main {
	static BookDao bd = new BookDaoImpl();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("========���¼=================");
		System.out.println("�������û���:");
		String username = sc.next();
		System.out.println("����������:");
		String password = sc.next();
		User user = new User(username,password);
		if(user!=null){
			System.out.println("��ϲ�㣬��½�ɹ���");
			while(true){
			System.out.println("                               ");
			System.out.println("==============================");
			System.out.println("=======��ӭ����ͼ�����ϵͳ=====");
			System.out.println("��ѡ�� 1.���  2.ȫ��  3.�������Ʋ�ѯ 4.�޸� 5.ɾ�� 6.�˳�");
			int select = sc.nextInt();
			if(select==1){
				//���
				Scanner sc1 = new Scanner(System.in);
		    	System.out.println("����������:");
		    	String bname = sc1.next();
		    	System.out.println("����������:");
		    	String bauthor = sc1.next();
		    	System.out.println("������۸�:");
		    	int bprice = sc1.nextInt();
		    	System.out.println("���������:");
		    	String btype = sc1.next();
		    	System.out.println("�����뱸ע:");
		    	String bmark = sc1.next();
		    	
		    	Book bk = new Book(bname,bauthor,bprice,btype,bmark);
		    	int i = bd.insert(bk);
		    	if(i>0){
					System.out.println("��ϲ����ӳɹ���");
				}else{
					System.out.println("���ʧ�ܣ�");
				}
			}else if(select==2){
				//��ѯ
				ArrayList<Book> list = bd.selectAll();
				for (Book book : list) {
					System.out.println(book);
				}
			}else if(select==3){
				//�������Ʋ�ѯ
				System.out.println("������Ҫ��ѯ������:");
		    	String bname=sc.next();
		    	bd.selectbname(bname);
			}else if(select==4){
				//�޸�
				Scanner sc2=new Scanner(System.in);
		    	System.out.println("��ѡ��Ҫ�޸ĵ���id:");
		    	int id=sc2.nextInt();
		    	Book book=bd.selectbooks(id);
		    	System.out.println("��������Ҫ�޸ĵ����: 1.���� 2.���� 3.���� 4.�۸� 5.��ע");
		    	int x=sc2.nextInt();
		    	String bname=book.getBname();
				String bauthor=book.getBauthor();
				String btype=book.getBtype();
				int bprice=book.getBprice();
				String bmark=book.getBmark();
		    	if(x==1){
		    		System.out.println("����������:");
		    		bname = sc.next();
		    	}else if(x==2){
		    		System.out.println("����������:");
		    		bauthor = sc.next();
		    	}else if(x==3){
		    		System.out.println("����������:");
		    		btype = sc.next();
		    	}else if(x==4){
		    		System.out.println("������۸�:");
		    		bprice = sc.nextInt();
		    	}else if(x==5){
		    		System.out.println("�����뱸ע:");
		    		bmark = sc.next();
		    	}
				Book bk = new Book(bname,bauthor,btype,bprice,bmark);
		    	int count = bd.update(bk,id);  
		    	if(count>0){
					System.out.println("��ϲ���޸ĳɹ���");
				}else{
					System.out.println("�޸�ʧ�ܣ�");
				}
			}else if(select==5){
				//ɾ��
				System.out.println("������Ҫɾ�����id:");
		    	int id2 = sc.nextInt();
		    	int i = bd.delete(id2);
		    	if(i>0){
					System.out.println("��ϲ��ɾ���ɹ���");
				}else{
					System.out.println("ɾ��ʧ�ܣ�");
				}
			}else if(select==6){
				//�˳�
				System.out.println("�˳���");
				break;
			}else{
				System.out.println("ѡ����������������");
			}
			}
		}else{
			System.out.println("�û��������룬��¼��������������");
		}
	}

}
