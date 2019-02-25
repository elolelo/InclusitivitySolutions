import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HandTest1 {
	Hand m_hand;
	
	@Before
	public void setUp() throws Exception {
		///super.setUp();
		m_hand = new Hand();
	}

	@Test
	public void test() {
		assertEquals(m_hand,m_hand);
		//fail("Not yet implemented");
	}

}
