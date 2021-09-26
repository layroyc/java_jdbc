package cn.hp.main;

import java.util.Scanner;

import cn.hp.dao.StudentDao;
import cn.hp.dao.StudentDaoImpl;
import cn.hp.model.Student;

public class Main {
	static Scanner sc= new Scanner(System.in);
	static StudentDao sd=new StudentDaoImpl();
	static Student s;
	public static void main(String[] args) {
		while(true){
		System.out.println("----------------------------------");
		System.out.println("��ѡ�� ��0.�˳���¼  1.��¼  2.�޸�����");
		System.out.println("----------------------------------");
		int num=sc.nextInt();
		if(num==0){
			System.out.println("�˳���¼��");
			break;
		}
		switch (num) {
		case 1:
//	        System.out.println("��ѡ���˵�¼");
			login();
			break;
		case 2:
//			System.out.println("��ѡ�����޸�����");
			changePwd();
			break;
		default:
			System.out.println("��ѡ�����Ч�����������룡");
			break;
		}
		}
	}
	private static void changePwd(){
		//�޸�����
		if(s!=null){
			System.out.println("�������µ����룡");
			String pwd = sc.next();
			s.setPwd(pwd);
			if(sd.changepwd(s)>0){
				System.out.println("�޸ĳɹ���");
			}else{
				System.out.println("�޸�ʧ�ܣ�");
			}
		}else{
			System.out.println("��δ��¼�ɹ� �޷��޸����룡 ���ȵ�¼");
		}
	}
	
	public static void login(){
		//��¼
		System.out.println("�������˺ţ�");
		String name = sc.next();
		System.out.println("���������룺");
		String pwd = sc.next();
		
		s=sd.login(name, pwd);
		if(s!=null){
			System.out.println("��½�ɹ�����ӭ"+s.getName());
		}else{
			System.out.println("��¼ʧ�ܣ� �˺��������");
		}
				
	}

}

