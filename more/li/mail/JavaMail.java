package li.mail;

public class JavaMail {
	public static void main(String[] args) {
		Sender sender = new Sender("smtp.qq.com", "416133823@qq.com", "buxiaode");
		Mail mail = new Mail();
		mail.setFrom("416133823@qq.com");
		mail.setTo("cdusj@qq.com");
		mail.setSubject("静夜思");
		mail.setContent("床前明月光");

		sender.send(mail);
	}
}