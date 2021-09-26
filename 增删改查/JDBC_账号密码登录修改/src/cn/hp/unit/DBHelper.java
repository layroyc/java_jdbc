package cn.hp.unit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBHelper {
	private String driver;
	private String url;
	private String user;
	private String pwd;
	private Connection conn;

	//1:加载驱动
	public DBHelper(){
		initProperties();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void initProperties() {
		Properties ps = new Properties();
		try {
			ps.load(DBHelper.class.getResourceAsStream("mysql_jdbc.properties"));
			driver=ps.getProperty("driver");
			url=ps.getProperty("url");
			user=ps.getProperty("user");
			pwd=ps.getProperty("pwd");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public Connection getConn(){
		try {
			//2：获取连接
			conn=DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	public void close(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
