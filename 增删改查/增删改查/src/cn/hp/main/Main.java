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
		System.out.println("========请登录=================");
		System.out.println("请输入用户名:");
		String username = sc.next();
		System.out.println("请输入密码:");
		String password = sc.next();
		User user = new User(username,password);
		if(user!=null){
			System.out.println("恭喜你，登陆成功！");
			while(true){
			System.out.println("                               ");
			System.out.println("==============================");
			System.out.println("=======欢迎来到图书管理系统=====");
			System.out.println("请选择 1.添加  2.全查  3.输入名称查询 4.修改 5.删除 6.退出");
			int select = sc.nextInt();
			if(select==1){
				//添加
				Scanner sc1 = new Scanner(System.in);
		    	System.out.println("请输入书名:");
		    	String bname = sc1.next();
		    	System.out.println("请输入作者:");
		    	String bauthor = sc1.next();
		    	System.out.println("请输入价格:");
		    	int bprice = sc1.nextInt();
		    	System.out.println("请输入类别:");
		    	String btype = sc1.next();
		    	System.out.println("请输入备注:");
		    	String bmark = sc1.next();
		    	
		    	Book bk = new Book(bname,bauthor,bprice,btype,bmark);
		    	int i = bd.insert(bk);
		    	if(i>0){
					System.out.println("恭喜你添加成功！");
				}else{
					System.out.println("添加失败！");
				}
			}else if(select==2){
				//查询
				ArrayList<Book> list = bd.selectAll();
				for (Book book : list) {
					System.out.println(book);
				}
			}else if(select==3){
				//输入名称查询
				System.out.println("请输入要查询的书名:");
		    	String bname=sc.next();
		    	bd.selectbname(bname);
			}else if(select==4){
				//修改
				Scanner sc2=new Scanner(System.in);
		    	System.out.println("请选择要修改的书id:");
		    	int id=sc2.nextInt();
		    	Book book=bd.selectbooks(id);
		    	System.out.println("请输入你要修改的序号: 1.书名 2.作者 3.类型 4.价格 5.备注");
		    	int x=sc2.nextInt();
		    	String bname=book.getBname();
				String bauthor=book.getBauthor();
				String btype=book.getBtype();
				int bprice=book.getBprice();
				String bmark=book.getBmark();
		    	if(x==1){
		    		System.out.println("请输入书名:");
		    		bname = sc.next();
		    	}else if(x==2){
		    		System.out.println("请输入作者:");
		    		bauthor = sc.next();
		    	}else if(x==3){
		    		System.out.println("请输入类型:");
		    		btype = sc.next();
		    	}else if(x==4){
		    		System.out.println("请输入价格:");
		    		bprice = sc.nextInt();
		    	}else if(x==5){
		    		System.out.println("请输入备注:");
		    		bmark = sc.next();
		    	}
				Book bk = new Book(bname,bauthor,btype,bprice,bmark);
		    	int count = bd.update(bk,id);  
		    	if(count>0){
					System.out.println("恭喜你修改成功！");
				}else{
					System.out.println("修改失败！");
				}
			}else if(select==5){
				//删除
				System.out.println("请输入要删除书的id:");
		    	int id2 = sc.nextInt();
		    	int i = bd.delete(id2);
		    	if(i>0){
					System.out.println("恭喜你删除成功！");
				}else{
					System.out.println("删除失败！");
				}
			}else if(select==6){
				//退出
				System.out.println("退出！");
				break;
			}else{
				System.out.println("选择有误，请重新输入");
			}
			}
		}else{
			System.out.println("用户名，密码，登录错误，请重新输入");
		}
	}

}
