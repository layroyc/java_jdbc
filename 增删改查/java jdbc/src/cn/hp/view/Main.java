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
		//程序入口方法
		System.out.println("欢迎进入用户管理系统");
		System.out.println("1.登录  2.退出");
		System.out.println("请输入功能序号：");
		int select=sc.nextInt();

		if(select==1){
			System.out.println("请输入用户名：");
			String u_name = sc.next();
			System.out.println("请输入密码：");
			String u_password= sc.next();
			tb_userDao e = new tb_userDaoImpl();
			s=e.login(u_name, u_password);
			if(s!=null){
				System.out.println("登录成功，进入主功能界面");
				System.out.print("1.用户信息查询");
				System.out.print("2.用户信息添加");
				int a=sc.nextInt();

				if(a==1){
					System.out.println("你选择了查询所有用户信息");
					tb_userDao ed= new tb_userDaoImpl();
					ArrayList<tb_user> l=ed.selectAll();
					for (tb_user tb_user : l) {
						System.out.println(tb_user);
					}		 
				}else if(a==2){
					System.out.println("你选择了新增一名用户");
					Scanner sc3= new Scanner(System.in);
					System.out.print("请输入用户账号：");
					String name= sc.next();
					System.out.print("请输入用户密码：");
					String password = sc.next();
					System.out.print("请输入用户年龄：");
					String age = sc.next();
					s=new tb_user(name,password,age);
					tb_userDao e1 = new tb_userDaoImpl();
					int i= e1.insert(s);
					if(i>0){
						System.out.println("恭喜你添加成功！");
					}else{
						System.out.println("添加失败！");
					}
				}
			}else{
				System.out.println("登录失败，请重新输入用户名和密码！");
			}
		}else if(select==2){
			System.out.println("退出！");
		}else{
			System.out.println("你选择了序号无效！");
		}

	}
}





