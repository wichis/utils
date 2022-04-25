package mx.ryo.puntoycoma.standalone;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import mx.ryo.puntoycoma.standalone.utils.EmailSender;

@SpringBootApplication
@EnableAutoConfiguration
public class StandaloneApplication {

	public static void main(String[] args) {
		System.out.println("Spring boot standalone application is working...");
		ApplicationContext ctx = SpringApplication.run(StandaloneApplication.class, args);

		EmailSender emailSender = (EmailSender) ctx.getBean("emailSender");
		emailSender.enviarNotificacion("wichiz1312@gmail.com",
				"",
				"https://www.edomex.gob.mx/");
	}

	@Bean(name = "labels")
	public ResourceBundle getLabels() {
		Locale locale = new Locale("es", "MX");
		ResourceBundle labels = ResourceBundle.getBundle("static.labels", locale);
		return labels;
	}

	@Bean(name = "errorCode")
	public ResourceBundle getErrorCode() {
		Locale locale = new Locale("es", "MX");
		ResourceBundle errorCode = ResourceBundle.getBundle("static.error_code", locale);
		return errorCode;
	}

	@Bean(name = "paths")
	public ResourceBundle getPaths() {
		ResourceBundle paths = ResourceBundle.getBundle("static.paths", Locale.getDefault());
		return paths;
	}
}
