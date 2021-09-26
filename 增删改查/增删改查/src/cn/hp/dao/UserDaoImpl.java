package cn.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.hp.entity.User;
import cn.hp.unit.DBHelper;

public class UserDaoImpl implements UserDao{

	public User login(String username, String password) {
		User user = null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//������������ȡ����
			conn = DBHelper.getConn();
		    //��дsql
			String sql = "select * from user where username=? and password=?";
			//����PreparedStatement��ִ��sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			//��������
			while(rs.next()){
				user = new User(
				    rs.getInt(1),
				    rs.getString(2),
				    rs.getString(3)
				);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					DBHelper.close(ps, rs, conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
		return null;
	}

}
