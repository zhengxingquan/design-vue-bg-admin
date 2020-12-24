package com.quan.monitor.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/***
 *  发送邮箱
 * @author zxq(956607644@qq.com)
 * @date 2020/11/29 21:30
 * @return
 */
@RestController
public class MailController {
	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("/send")
	public String send() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("956607644@qq.com");
		message.setTo("956607644@qq.com");
		message.setSubject("测试邮件");
		message.setText("好好学习");
		javaMailSender.send(message);
		return "hello";
	}

	@GetMapping("/send1")
	public String send1() throws MessagingException {

		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "utf-8");

		msgHelper.setFrom("956607644@qq.com");
		msgHelper.setTo("956607644@qq.com");
		msgHelper.setSubject("测试发送带附件的邮件");
		msgHelper.setText("测试邮件");

		FileSystemResource file = new FileSystemResource(new File("classpath:/images/test.jpg"));
		msgHelper.addAttachment("测试.jpg", file); // 添加附件

		// Properties prop = new Properties();
		// prop.put("mail.smtp.auth", "true");
		// prop.put("mail.smtp.timeout", "25000");
		// javaMailSender.setJavaMailProperties(prop);

		javaMailSender.send(msg);

		return "hello";
	}
}
