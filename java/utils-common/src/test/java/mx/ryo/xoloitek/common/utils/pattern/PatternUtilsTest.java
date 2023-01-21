package mx.ryo.xoloitek.common.utils.pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mx.ryo.xoloitek.commons.utils.pattern.ConceptoType;
import mx.ryo.xoloitek.commons.utils.pattern.PatternUtils;

public class PatternUtilsTest {

	@Test
	public void testMatchesStringConceptoType1() {
		assertTrue(PatternUtils.matches("42243", ConceptoType.CODIGO_POSTAL));
	}
	
	@Test
	public void testMatchesStringConceptoType2() {
		assertFalse(PatternUtils.matches("abc", ConceptoType.CODIGO_POSTAL));
	}
	
	@Test
	public void testMatchesStringConceptoType3() {
		assertFalse(PatternUtils.matches(null, ConceptoType.CODIGO_POSTAL));
	}

	@Test
	public void testMatchesStringString1() {
		assertTrue(PatternUtils.matches("20100", "[0-9]{5}"));
	}

	@Test
	public void testMatchesStringString2() {
		assertFalse(PatternUtils.matches("abcde", "[0-9]{5}"));
	}
	
	@Test
	public void testMatchesStringString3() {
		assertFalse(PatternUtils.matches(null, "[0-9]{5}"));
	}

}
