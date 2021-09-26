package cn.hp.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) throws IOException {
	//��ȡ�����ļ���ָ�������ļ�λ��
	InputStream in = TestProperties.class.getResourceAsStream("/mysql.jdbc.properties");
	//ʹ��Properties����������Ϣ�����Լ�ֵ�Է�ʽ����
	Properties pr = new Properties();
	  pr.load(in);     
	
	//��ȡ
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
