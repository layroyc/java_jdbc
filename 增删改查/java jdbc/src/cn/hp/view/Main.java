package cn.hp.view;

import java.util.ArrayList;
import java.util.Scanner;

import cn.hp.Dao.tb_userDao;
import cn.hp.Dao.tb_userDaoImpl;
import cn.hp.entity.tb_user;

public class Main {
	static tb_user s;
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		//������ڷ���
		System.out.println("��ӭ�����û�����ϵͳ");
		System.out.println("1.��¼  2.�˳�");
		System.out.println("�����빦����ţ�");
		int select=sc.nextInt();

		if(select==1){
			System.out.println("�������û�����");
			String u_name = sc.next();
			System.out.println("���������룺");
			String u_password= sc.next();
			tb_userDao e = new tb_userDaoImpl();
			s=e.login(u_name, u_password);
			if(s!=null){
				System.out.println("��¼�ɹ������������ܽ���");
				System.out.print("1.�û���Ϣ��ѯ");
				System.out.print("2.�û���Ϣ���");
				int a=sc.nextInt();

				if(a==1){
					System.out.println("��ѡ���˲�ѯ�����û���Ϣ");
					tb_userDao ed= new tb_userDaoImpl();
					ArrayList<tb_user> l=ed.selectAll();
					for (tb_user tb_user : l) {
						System.out.println(tb_user);
					}		 
				}else if(a==2){
					System.out.println("��ѡ��������һ���û�");
					Scanner sc3= new Scanner(System.in);
					System.out.print("�������û��˺ţ�");
					String name= sc.next();
					System.out.print("�������û����룺");
					String password = sc.next();
					System.out.print("�������û����䣺");
					String age = sc.next();
					s=new tb_user(name,password,age);
					tb_userDao e1 = new tb_userDaoImpl();
					int i= e1.insert(s);
					if(i>0){
						System.out.println("��ϲ����ӳɹ���");
					}else{
						System.out.println("���ʧ�ܣ�");
					}
				}
			}else{
				System.out.println("��¼ʧ�ܣ������������û��������룡");
			}
		}else if(select==2){
			System.out.println("�˳���");
		}else{
			System.out.println("��ѡ���������Ч��");
		}

	}
}





