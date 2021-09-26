package cn.hp.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) throws IOException {
		//��ȡ�����ļ���ָ�������ļ�λ��
		InputStream in = TestProperties.class.getResourceAsStream("/mysql_jdbc.properties");
		//ʹ��Properties����������Ϣ�����Լ�ֵ�Է�ʽ����
		Properties pr = new Properties();
		pr.load(in);
		
		//��ȡ
		String driver = pr.getProperty("driver");
	    System.out.println(driver);
	    
	    String url = pr.getProperty("url");
	    System.out.println(url);
	    
	    String name = pr.getProperty("name");
	    System.out.println(name);
	    
	    String pwd  = pr.getProperty("pwd");
	    System.out.println(pwd );
	}

}
