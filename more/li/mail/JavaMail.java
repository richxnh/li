package li.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMail {
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.qq.com");
		properties.put("mail.smtp.auth", true);
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("416133823@qq.com", "buxiaode");
			}
		});
		session.setDebug(true);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("416133823@qq.com"));
		message.addRecipient(RecipientType.TO, new InternetAddress("cdusj@qq.com"));
		message.setSubject("邮件标题");
		MimeMultipart multipart = new MimeMultipart();
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setHeader("Content-Transfer-Encoding", "base64");
		bodyPart.setContent("邮件内容", "text/html;charset=UTF-8");
		multipart.addBodyPart(bodyPart);
		message.setContent(multipart);
		Transport.send(message);
		System.out.println("done");
	}
}