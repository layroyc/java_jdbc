package cn.hp.unit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Properties;
import cn.hp.test.TestProperties;
//工具类封装
public class DBHelper {
      //创建保存配置信息的对象 Properties 的特点一键值对保存信息，并且类型是String
	//是有的有private
	private static Properties pr = new Properties();
	
	static{
		//静态代码块 只执行一次 当这个类被调用的时候 静态代码块就开始加载执行	
	InputStream in=null;
	try {
		//读取配置文件，指定配置文件位置
	in = TestProperties.class.getResourceAsStream("/mysql_jdbc.properties");
	//将流中信息加载到pr 中保存   
	pr.load(in);
	//1:加载驱动	
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
	//提供获取连接功能
	public static Connection getConn() throws ClassNotFoundException, SQLException{
		//2:获取连接
		Connection conn = DriverManager.getConnection(pr.getProperty("url"), pr.getProperty("name"), pr.getProperty("pwd"));;
		return conn;
	}
	  //提供关闭资源的功能-->针对于查询
	public static void close(PreparedStatement ps,ResultSet rs,Connection conn) throws SQLException{
		if(ps!=null) ps.close();
		if(rs!=null) rs.close();
		if(conn!=null) conn.close();
	}
	//方法重载-->针对于查询以外的   增删改
	public static void close(PreparedStatement ps,Connection conn) throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
}
