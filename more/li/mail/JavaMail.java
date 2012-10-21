package li.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.qq.com");
		properties.put("mail.smtp.auth", true);

		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("416133823@qq.com", "buxiaode");
			}
		};

		Session session = Session.getDefaultInstance(properties, authenticator);
		session.setDebug(true);

		Message message = new MimeMessage(session);
		message.setSentDate(new Date());

		message.setFrom(new InternetAddress("416133823@qq.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress("cdusj@qq.com"));

		message.setSubject("邮件标题");
		message.setText("邮件内容");

		Transport.send(message);

		System.out.println("done");
	}
}