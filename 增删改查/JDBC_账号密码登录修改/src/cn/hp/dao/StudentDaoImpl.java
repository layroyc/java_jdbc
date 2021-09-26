package cn.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.hp.model.Student;
import cn.hp.unit.DBHelper;

public class StudentDaoImpl implements StudentDao {

	private Student s;

	@Override
	public Student login(String name, String pwd) {
		//登录
		//加载驱动
		DBHelper db = new DBHelper();
		//获取连接
		Connection conn = db.getConn();
		//书写sql语句
		String sql ="select * from student where name=? and pwd=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student s=null;
		//创建prepareStatement,执行sql
		try {
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs =ps.executeQuery();
			//处理结果集
			if(rs.next()){
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPwd(rs.getString("pwd"));
			}
			//关流
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public int changepwd(Student s) {
		//修改密码
		//加载驱动
				DBHelper db = new DBHelper();
				//获取连接
				Connection conn = db.getConn();
				//书写sql语句
				String sql ="update student set pwd=? where id=?";
				PreparedStatement ps=null;
				int num=0;
				//创建prepareStatement,执行sql
				try {
					ps =conn.prepareStatement(sql);
					ps.setString(1, s.getPwd());
					ps.setInt(2, s.getId());
					num = ps.executeUpdate();
					//处理结果集
					//关流
					ps.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		return num;
	}

}
