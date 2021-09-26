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
		//��¼
		//��������
		DBHelper db = new DBHelper();
		//��ȡ����
		Connection conn = db.getConn();
		//��дsql���
		String sql ="select * from student where name=? and pwd=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student s=null;
		//����prepareStatement,ִ��sql
		try {
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs =ps.executeQuery();
			//��������
			if(rs.next()){
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPwd(rs.getString("pwd"));
			}
			//����
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
		//�޸�����
		//��������
				DBHelper db = new DBHelper();
				//��ȡ����
				Connection conn = db.getConn();
				//��дsql���
				String sql ="update student set pwd=? where id=?";
				PreparedStatement ps=null;
				int num=0;
				//����prepareStatement,ִ��sql
				try {
					ps =conn.prepareStatement(sql);
					ps.setString(1, s.getPwd());
					ps.setInt(2, s.getId());
					num = ps.executeUpdate();
					//��������
					//����
					ps.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		return num;
	}

}
