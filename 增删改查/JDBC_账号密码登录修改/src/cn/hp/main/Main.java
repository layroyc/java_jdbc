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
		System.out.println("请选择 ：0.退出登录  1.登录  2.修改密码");
		System.out.println("----------------------------------");
		int num=sc.nextInt();
		if(num==0){
			System.out.println("退出登录！");
			break;
		}
		switch (num) {
		case 1:
//	        System.out.println("你选择了登录");
			login();
			break;
		case 2:
//			System.out.println("你选择了修改密码");
			changePwd();
			break;
		default:
			System.out.println("你选择的无效，请重新输入！");
			break;
		}
		}
	}
	private static void changePwd(){
		//修改密码
		if(s!=null){
			System.out.println("请输入新的密码！");
			String pwd = sc.next();
			s.setPwd(pwd);
			if(sd.changepwd(s)>0){
				System.out.println("修改成功！");
			}else{
				System.out.println("修改失败！");
			}
		}else{
			System.out.println("你未登录成功 无法修改密码！ 请先登录");
		}
	}
	
	public static void login(){
		//登录
		System.out.println("请输入账号：");
		String name = sc.next();
		System.out.println("请输入密码：");
		String pwd = sc.next();
		
		s=sd.login(name, pwd);
		if(s!=null){
			System.out.println("登陆成功！欢迎"+s.getName());
		}else{
			System.out.println("登录失败！ 账号密码错误！");
		}
				
	}

}

