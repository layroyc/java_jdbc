package cn.hp.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) throws IOException {
	//读取配置文件，指定配置文件位置
	InputStream in = TestProperties.class.getResourceAsStream("/mysql.jdbc.properties");
	//使用Properties解析流中信息，并以键值对方式保存
	Properties pr = new Properties();
	  pr.load(in);     
	
	//获取
	String driver = pr.getProperty("driver");
    System.out.println(driver);
    
    String url = pr.getProperty("url");
    System.out.println(url);
    
    String username = pr.getProperty("username");
    System.out.println(username);
    
    String password = pr.getProperty("password");
    System.out.println(password);
	}
}
