package mx.ryo.xoloit.amoxatli.exception.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.ryo.xoloit.utils.exception.BusinessLogicException;
import mx.ryo.xoloit.utils.exception.DevelLogicException;
import mx.ryo.xoloit.utils.exception.devel.DataNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = { DevelLogicException.class })
	public ResponseEntity<String> handleIOException(DevelLogicException devLogExc) {
		if (devLogExc instanceof DataNotFoundException) {
			logger.error("DataNotFoundException handler executed" + devLogExc.getMessage());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(devLogExc.getMessage());
		} else {
			logger.error("DevelLogicException handler executed" + devLogExc.getMessage());
			return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(devLogExc.getMessage());
		}
	}
	
	@ExceptionHandler(value = { BusinessLogicException.class })
	public ResponseEntity<String> handleIOException(BusinessLogicException devLogExc) {
		logger.error("Solicita apoyo con tu administrador para atender el fallo" + devLogExc.getMessage());
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(devLogExc.getMessage());
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<String> handleIOException(Exception devLogExc) {
		logger.error("DevelLogicException handler executed" + devLogExc.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
				"Lo sentimos, no pudimos procesar la solcitud. Intentalo más tarde (Sí el problema persiste, comunicate con tu administrador).");

	}
}
