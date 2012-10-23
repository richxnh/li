package li.mail;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JavaMail {
	static final String[] address = { "cdusj@qq.com", "154520174@qq.com", "1406678816@qq.com", "767702147@qq.com", "573167315@qq.com", "289111782@qq.com", "752433022@qq.com", "2515282104@qq.com", "1019265060@qq.com", "1029207678@qq.com", "1694352061@qq.com", "55942119@qq.com", "821721345@qq.com", "965245282@qq.com", "847096360@qq.com", "2267876466@qq.com", "136122073@qq.com", "963314346@qq.com", "939267542@qq.com" };

	public static void main(String[] args) {
		Sender sender = new Sender("smtp.qq.com", "1055515958@qq.com", "buxiaode");
		Beetl beetl = new Beetl(new File("D:\\workspace\\li\\more\\li\\mail\\mail_1.htm"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "黎明伟");
		map.put("date", "2012-10-22");

		Mail mail = new Mail();
		mail.setTo("cdusj@qq.com");
		mail.setSubject("这是一封测试邮件");
		mail.setContent(beetl.merge(map));
		sender.send(mail);
	}
}