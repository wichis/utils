package mx.ryo.xoloitek.common.utils.uuid;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mx.ryo.xoloitek.commons.utils.pattern.PatternUtils;

public class SidFactoryTest {
	@Test
	public void testGenerateSid1() {
		assertTrue(PatternUtils.matches(new SidFactory().generateSid(SidType.USER), "^[a-zA-Z]{4}(:)[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$"));
	}
	
	@Test
	public void testGenerateSid2() {
		assertTrue(PatternUtils.matches(new SidFactory().generateSid(SidType.PERSON), "^[a-zA-Z]{4}(:)[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$"));
	}
	
	
}
