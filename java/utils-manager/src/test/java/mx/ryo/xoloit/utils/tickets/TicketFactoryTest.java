package mx.ryo.xoloit.utils.tickets;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mx.ryo.xoloit.utils.pattern.ConceptoType;
import mx.ryo.xoloit.utils.pattern.PatternUtils;
import mx.ryo.xoloit.utils.types.AppType;

public class TicketFactoryTest {

	@Test
	public void testGenerar1() {
		assertTrue(PatternUtils.matches(TicketFactory.generar(AppType.TLACATL, "U11223344556"), ConceptoType.TICKET_ISSUE));
		
	}
	
	@Test
	public void testGenerar2() {
		assertFalse(PatternUtils.matches(TicketFactory.generar(AppType.TLACATL, "U00000000"), ConceptoType.TICKET_ISSUE));
		
	}

}
