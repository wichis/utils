package mx.ryo.puntoycoma.standalone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import mx.ryo.puntoycoma.standalone.utils.EmailSender;

@SpringBootApplication
@EnableAutoConfiguration
public class StandaloneApplication {
	private static final Logger infoLogger = LoggerFactory.getLogger("infoLogger");

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(StandaloneApplication.class, args);
		
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");  
		
		StringBuilder sb = new StringBuilder();

		EmailSender emailSender = (EmailSender) ctx.getBean("emailSender");
		int noDia = 1;
		final int sizePage = 8500;
		int indexInicio = (noDia - 1) * sizePage;
		int indexFinal = (noDia * sizePage) - 1;
		
		
		int countEmails = 0;
		StandaloneApplication standalon = new StandaloneApplication();

		URL url = standalon.getClass().getResource("/auxs/set_correos.txt");
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(url.getPath()), "ISO-8859-1"))) {
			File resumenEnvios = new File(String.format("/tmp/envios-said_DIA%03d.txt", noDia));

			
		    List<String> lines = reader.lines()
		                              .skip(indexInicio)
		                              .limit(sizePage)
		                              .collect(Collectors.toList());
		    sb.append(String.format("FECHA INICIO: %1$s\r\n", dateFormat.format(date)));
		    sb.append(String.format("Dia: %1$d\r\n", noDia));
		    String ultimoEnviado = "";
		    int indexLast = 0;
			for(String datos : lines) {
				ultimoEnviado = datos;
				String[] argsData = datos.split(";");
				String[] destinatarios = argsData[6].replaceAll(" ", "").split("\\|");
				emailSender.enviarNotificacion(destinatarios,
						"",
						"https://www.edomex.gob.mx/");
				countEmails += destinatarios.length;
				if(countEmails > sizePage) {
					break;
				}
				indexLast++;
				Thread.sleep(500);
			}
			sb.append(String.format("Ultimo indice: %1$s\r\n", indexLast));
			sb.append(String.format("Ultimo correo enviado: %1$s\r\n", ultimoEnviado));
			sb.append(String.format("Correos enviados: %1$d\r\n", countEmails));
			sb.append(String.format("FECHA TERMINO: %1$s\r\n", dateFormat.format(date)));
			
			FileWriter fw = new FileWriter(resumenEnvios.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close(); // Be sure to close BufferedWriter
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



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
