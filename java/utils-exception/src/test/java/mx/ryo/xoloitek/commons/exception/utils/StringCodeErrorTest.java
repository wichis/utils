package mx.ryo.xoloitek.commons.exception.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mx.ryo.xoloitek.commons.exception.type.LevelError;

class StringCodeErrorTest {

	@Test
	void format() {
		assertEquals("ERRC-0001", new StringCodeError(LevelError.CLIENT, 1).format());
	}

	@Test
	void format1() {
		assertEquals("ERRE-0013", new StringCodeError(LevelError.EXTERNAL_DEPENDENCY, 13).format());
	}
}
