package cn.hp.main;

import java.util.ArrayList;
import java.util.Scanner;

import cn.hp.dao.Tb_userDao;
import cn.hp.dao.Tb_userDaoImpl;
import cn.hp.entity.Tb_user;

public class Main {
	//ʵ��������
	static Tb_userDao tb = new Tb_userDaoImpl();
	static Tb_user t;

	public static void main(String[] args) {

		System.out.println("��ӭ�����û�����ϵͳ��");
		System.out.println("��ѡ�� 1����¼    2���˳�");
		System.out.println("�����빦����ţ�");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if(num==1){
			//��¼
			System.out.println("�������û�����");
			String u_name = sc.next();
			System.out.println("���������룺");
			String u_password = sc.next();
			while(true){
			t=tb.login(u_name, u_password);
			if(t!=null){
				System.out.println("��½�ɹ�����ӭ���������ܽ���");
				System.out.println("��½�ɹ���ѡ����     1���û���Ϣ��ѯ    2���û���Ϣ���");
				System.out.println("�����빦����ţ�");
				Scanner sc1 = new Scanner(System.in);
				int num1 = sc.nextInt();
				if(num1==1){
					//��ѯȫ��
					ArrayList<Tb_user> list = tb.selectAll();
					for (Tb_user tb_user : list) {
						System.out.println(tb_user);
					}
				}else if(num1==2){
					System.out.println("��ѡ�������һ���û���Ϣ��");
					Scanner sc3 = new Scanner(System.in);
					System.out.println("�������û���:");
					String name = sc.next();
					System.out.println("����������:");
					String password = sc.next();
					System.out.println("����������:");
					String u_age = sc.next();
					t = new Tb_user(name,password,u_age);
					int i = tb.insert(t);
					if(i>0){
						System.out.println("��ϲ����ӳɹ���");
					}else{
						System.out.println("���ʧ�ܣ�");
					}
				}
				
			}else{
				System.out.println("��¼ʧ�ܣ� �����������û�����");
				break;
			}
			}
		}else if(num==2){
			System.out.println("�˳���");
		}



	}

}