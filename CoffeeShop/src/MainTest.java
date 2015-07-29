import org.junit.*;
import static org.junit.Assert.*;

public class MainTest {
	
	@Test
	public void testMain_1()
		throws Exception {

		Main result = new Main();

		assertNotNull(result);
	}

	
	@Test
	public void testMain_2()
		throws Exception {
		String[] args = new String[] {};

		Main.main(args);

		
	}

	
	@Before
	public void setUp()
		throws Exception {
		
	}

	
	@After
	public void tearDown()
		throws Exception {
		
	}

	
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(MainTest.class);
	}
}