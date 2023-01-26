package mx.ryo.xoloitek.commons.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BusinessLogicExceptionTest {

	@Test
	void test() throws BusinessLogicException {
		BusinessLogicException exc = new BusinessLogicException();
		assertEquals("ERRU-9999", exc.getScode().format());
	}

}
