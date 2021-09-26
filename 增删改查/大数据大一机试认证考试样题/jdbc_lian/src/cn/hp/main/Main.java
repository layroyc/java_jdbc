package cn.hp.main;

import java.util.ArrayList;
import java.util.Scanner;

import cn.hp.dao.Tb_userDao;
import cn.hp.dao.Tb_userDaoImpl;
import cn.hp.entity.Tb_user;

public class Main {
	//实例化对象
	static Tb_userDao tb = new Tb_userDaoImpl();
	static Tb_user t;

	public static void main(String[] args) {

		System.out.println("欢迎进入用户管理系统：");
		System.out.println("请选择： 1、登录    2、退出");
		System.out.println("请输入功能序号：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if(num==1){
			//登录
			System.out.println("请输入用户名：");
			String u_name = sc.next();
			System.out.println("请输入密码：");
			String u_password = sc.next();
			while(true){
			t=tb.login(u_name, u_password);
			if(t!=null){
				System.out.println("登陆成功，欢迎进入主功能界面");
				System.out.println("登陆成功，选择功能     1、用户信息查询    2、用户信息添加");
				System.out.println("请输入功能序号：");
				Scanner sc1 = new Scanner(System.in);
				int num1 = sc.nextInt();
				if(num1==1){
					//查询全部
					ArrayList<Tb_user> list = tb.selectAll();
					for (Tb_user tb_user : list) {
						System.out.println(tb_user);
					}
				}else if(num1==2){
					System.out.println("你选择了添加一名用户信息：");
					Scanner sc3 = new Scanner(System.in);
					System.out.println("请输入用户名:");
					String name = sc.next();
					System.out.println("请输入密码:");
					String password = sc.next();
					System.out.println("请输入年龄:");
					String u_age = sc.next();
					t = new Tb_user(name,password,u_age);
					int i = tb.insert(t);
					if(i>0){
						System.out.println("恭喜你添加成功！");
					}else{
						System.out.println("添加失败！");
					}
				}
				
			}else{
				System.out.println("登录失败！ 请重新输入用户名！");
				break;
			}
			}
		}else if(num==2){
			System.out.println("退出！");
		}



	}

}