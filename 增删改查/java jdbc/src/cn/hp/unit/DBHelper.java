package cn.hp.unit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import cn.hp.Test.TestProperties;

//�������װ   DBHelper
public class DBHelper {
	//��������������Ϣ�Ķ��� Properties���ص��Լ�ֵ�Ա�����Ϣ������������String
	 private static Properties pr = new Properties();
		
		static{
			//��̬����� ִֻ��һ�� ������౻���õ�ʱ�� ��̬�����Ϳ�ʼ����ִ��	
		InputStream in=null;
		try {
			//��ȡ�����ļ���ָ�������ļ�λ��
		in = TestProperties.class.getResourceAsStream("/mysql.jdbc.properties");
		//��������Ϣ���ص�pr �б���   
		pr.load(in);
		//1:��������	
			Class.forName(pr.getProperty("driver"));
		} catch (Exception e) {

		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
					
		}  
		//�ṩ��ȡ���ӹ���
		public static Connection getConn() throws ClassNotFoundException, SQLException{
			//2:��ȡ����
			Connection conn = DriverManager.getConnection(pr.getProperty("url"), pr.getProperty("username"), pr.getProperty("password"));
			return conn;
		}
		  //�ṩ�ر���Դ�Ĺ���-->����ڲ�ѯ
		public static void close(PreparedStatement ps,ResultSet rs,Connection conn) throws SQLException{
			if(ps!=null) ps.close();
			if(rs!=null) rs.close();
			if(conn!=null) conn.close();
		}
		//��������-->����ڲ�ѯ�����   ��ɾ��
		public static void close(PreparedStatement ps,Connection conn) throws SQLException{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}

}
