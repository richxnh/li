package li.mail;

import org.apache.commons.mail.SimpleEmail;

public class T {
	public static void main(String[] args) throws Exception {
		  SimpleEmail email = new SimpleEmail(); // 构造一个mail对象
		  email.setHostName("smtp.qq.com");
	      email.setFrom("416133823@qq.com");// 设置发送人
		  email.setAuthentication("416133823@qq.com", "buxiaode");
	      email.setSubject("邮件测试标题");// 设置主题
	      email.setContent("测试内容是我自己的", "text/plain;charset=GBK");// 设置内容	
	      email.addTo("cdusj@foxmail.com ");// 设置发对象
	      email.send();// 发送
	      
	      System.out.println("done");
	}
}