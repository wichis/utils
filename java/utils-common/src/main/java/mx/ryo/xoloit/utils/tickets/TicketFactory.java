package mx.ryo.xoloit.utils.tickets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import mx.ryo.xoloit.utils.types.AppType;

public class TicketFactory {
	private final static String FORMAT = "%1$s%2$s%3$s";
	/**
	 * Generar un ticket basado en la aplicacion+feha+usuario.
	 * @param appType {@link AppType}
	 * @param usuario U[0-9]{11}
	 * @return
	 */
	public final static String generar(AppType appType, String usuario) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmssSSS");
		System.out.println(String.format(FORMAT, appType.getCve(), format.format(LocalDateTime.now()), usuario));
		return String.format(FORMAT, appType.getCve(), format.format(LocalDateTime.now()), usuario);
	}
}
