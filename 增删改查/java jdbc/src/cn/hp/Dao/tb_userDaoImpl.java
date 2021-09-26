package cn.hp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.hp.unit.DBHelper;
import cn.hp.entity.tb_user;

public class tb_userDaoImpl implements tb_userDao{
  //登录
public tb_user login(String u_name,String u_password) {

		//2.获取连接
		Connection conn = null;
		try {
			conn = DBHelper.getConn();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		//3.书写sql语句
		String sql="select * from tb_user where u_name=? and u_password=?";
		//4.准备执行语句的对象PreparedStatement
		PreparedStatement ps=null;
		ResultSet rs=null;
		tb_user t=null;
		 try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, u_name);
			ps.setString(2, u_password);
		 //5.执行语句，得到结果
			rs=ps.executeQuery();
		//6.处理结果集
			if(rs.next()){ //登录  
				t=new tb_user(rs.getString("u_name"),rs.getString("u_password"));	
		 }
		//7.关闭数据库
//			  rs.close();
//			  ps.close();
//	          conn.close();
			DBHelper.close(ps, rs, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;		
	}
     //添加
	public int insert(tb_user tb_user) {
		Connection con = null;
		PreparedStatement ps=null;
		int i=0;
		try {
			//书写sql语句
			con=DBHelper.getConn();
			String sql2 = "insert into tb_user(u_name,u_password,u_age) values (?,?,?)";
			//创建preparedStatement,执行sql
			ps=con.prepareStatement(sql2);
			ps.setString(1,tb_user.getU_name());
			ps.setString(2, tb_user.getU_password());
			ps.setString(3, tb_user.getU_age());
			 i=ps.executeUpdate();
		     System.out.println(i);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("插入有问题！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}
		return i;
		
	}		
  //查询所有
	public ArrayList<tb_user> selectAll() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		ArrayList<tb_user> l = new ArrayList<tb_user>();
		try {
			con=DBHelper.getConn();
			String sql2="select * from tb_user";
			 ps=con.prepareStatement(sql2);
			ResultSet rs=ps.executeQuery(); 
			tb_user e=null;
			while(rs.next()){
				e=new tb_user(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
						); 
				l.add(e);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("连接SQl异常");
			}
		}	
		return l;		
	}

}
