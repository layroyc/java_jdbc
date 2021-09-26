package cn.hp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.hp.unit.DBHelper;
import cn.hp.entity.tb_user;

public class tb_userDaoImpl implements tb_userDao{
  //��¼
public tb_user login(String u_name,String u_password) {

		//2.��ȡ����
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
		//3.��дsql���
		String sql="select * from tb_user where u_name=? and u_password=?";
		//4.׼��ִ�����Ķ���PreparedStatement
		PreparedStatement ps=null;
		ResultSet rs=null;
		tb_user t=null;
		 try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, u_name);
			ps.setString(2, u_password);
		 //5.ִ����䣬�õ����
			rs=ps.executeQuery();
		//6.��������
			if(rs.next()){ //��¼  
				t=new tb_user(rs.getString("u_name"),rs.getString("u_password"));	
		 }
		//7.�ر����ݿ�
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
     //���
	public int insert(tb_user tb_user) {
		Connection con = null;
		PreparedStatement ps=null;
		int i=0;
		try {
			//��дsql���
			con=DBHelper.getConn();
			String sql2 = "insert into tb_user(u_name,u_password,u_age) values (?,?,?)";
			//����preparedStatement,ִ��sql
			ps=con.prepareStatement(sql2);
			ps.setString(1,tb_user.getU_name());
			ps.setString(2, tb_user.getU_password());
			ps.setString(3, tb_user.getU_age());
			 i=ps.executeUpdate();
		     System.out.println(i);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���������⣡");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("����SQl�쳣");
			}
		}
		return i;
		
	}		
  //��ѯ����
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
				System.out.println("����SQl�쳣");
			}
		}	
		return l;		
	}

}
