package mx.ryo.xoloitek.commons.exception.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import mx.ryo.xoloitek.commons.exception.DevelLogicException;
import mx.ryo.xoloitek.commons.exception.type.LevelError;

class StandardResumeTest {

	@Test
	void getResume() throws DevelLogicException {
		assertNotNull(StandardResume.getResume(LevelError.CLIENT));
	}

	@Test
	void getResume1() throws DevelLogicException {
		assertNotNull(StandardResume.getResume(LevelError.EXTERNAL_DEPENDENCY));
	}

	@Test
	void getResume2() throws DevelLogicException {
		assertNotNull(StandardResume.getResume(LevelError.INTERNAL_KNOWN));
	}

	@Test
	void getResume3() throws DevelLogicException {
		assertNotNull(StandardResume.getResume(LevelError.INTERNAL_UNKNOWN));
	}

	@Test
	void getResume4() throws DevelLogicException {
		assertNotNull(StandardResume.getResume(LevelError.LOCAL_DEPENDENCY));
	}

}
