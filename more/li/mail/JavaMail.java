package li.mail;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JavaMail {
	public static void main(String[] args) {
		Sender sender = new Sender("smtp.qq.com", "416133823@qq.com", "buxiaode");
		Beetl beetl = new Beetl(new File("D:/workspace/li/more/li/mail/mail_1.htm"));
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name", "黎明伟");
		map.put("date", "2012-10-22");

		Mail mail = new Mail();
		mail.setFrom("416133823@qq.com");
		mail.setTo("cdusj@qq.com");
		mail.setSubject("静夜思");
		mail.setContent(beetl.merge(map));
		sender.send(mail);
	}
}