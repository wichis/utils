package mx.ryo.puntoycoma.standalone.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component("emailSender")
public class EmailSender {
	public final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String fromMail;

	@Async
	public void enviarNotificacion(String to, String notificacion, String urlRedirect) {
		StringBuilder bldr = new StringBuilder();
		String str;

		URL url = this.getClass().getResource("/templates/email-notificacion-mige-said.html");
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(url.getPath()), "ISO-8859-1"));
			while ((str = in.readLine()) != null)
				bldr.append(str);

			in.close();

			MimeMessage msg = javaMailSender.createMimeMessage();

			MimeMessageHelper helper;
			helper = new MimeMessageHelper(msg, false);
			helper.setFrom(fromMail);
			helper.setTo(new String[] { to });
			helper.setSubject("MIGE | SAID | Notificaciones");
			helper.setText(bldr.toString().replace("_REPLACE_MSG_INFORMATIVO_", notificacion)
					.replace("_REPLACE_URL_REDIRECT_", urlRedirect), true);

			javaMailSender.send(msg);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
