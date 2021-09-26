package cn.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.hp.entity.Tb_user;
import cn.hp.unit.DBHelper;


public class Tb_userDaoImpl implements Tb_userDao {
    //登录
	@Override
	public Tb_user login(String u_name, String u_password) {
		Connection conn=null;
		try {
			conn = DBHelper.getConn();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
		    e1.printStackTrace();
		}//获取数据库连接
		//3.准备SQL语句
		String sql="select * from tb_user where u_name=? and u_password=?";
		//4.准备执行语句的对象Statement
		PreparedStatement ps=null;
		ResultSet rs=null;
		Tb_user s=null;
		try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, u_name);
		ps.setString(2, u_password);
		//5.执行语句 得到结果
		rs= ps.executeQuery();
		//6.处理结果 
		if(rs.next()){
			s=new Tb_user(rs.getString("u_name"), rs.getString("u_password"));
					 }
			//7.关闭数据库
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}						
		return s;
	}
	 //查询
	@Override
	public ArrayList<Tb_user> selectAll() {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	ArrayList<Tb_user> list = new ArrayList<Tb_user>();
     try {
		//获取连接
		conn = DBHelper.getConn();
	    //书写sql语句
		String sql = "select * from tb_user";
		//创建preparedStatement,执行sql
		ps = conn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    //处理结果集
		Tb_user p = null;
	    while(rs.next()){
	    //调用有参构造直接赋值创建对象
	    p=new Tb_user(
		      rs.getInt(1),
			  rs.getString(2),
			  rs.getString(3),
			  rs.getString(4)	
			);
			list.add(p);
	}
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally{
		try {
		    DBHelper.close(ps, rs, conn);
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
			return list;
 }
    //添加
	@Override
	public int insert(Tb_user tb_user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBHelper.getConn();
			//书写sql语句
			String sql = "insert into tb_user(u_name,u_password,u_age) values (?,?,?)";
			//创建preparedStatement,执行sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, tb_user.getU_name());
			ps.setString(2, tb_user.getU_password());
			ps.setString(3, tb_user.getU_age());
			int count = ps.executeUpdate();
			return count;
		}catch (SQLException e) {
			System.out.println("插入有问题");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	

}
