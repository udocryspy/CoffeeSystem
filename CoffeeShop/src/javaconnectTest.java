import java.sql.Connection;

import org.junit.*;

import static org.junit.Assert.*;


public class javaconnectTest {
	
	@Test
	public void testJavaconnect_1()
		throws Exception {
		javaconnect result = new javaconnect();
		assertNotNull(result);
		
	}

	
	@Test
	public void testConnecrDB_1()
		throws Exception {

		Connection result = javaconnect.ConnecrDB();

		
		assertNotNull(result);
	}


	@Test
	public void testConnecrDB_2()
		throws Exception {

		Connection result = javaconnect.ConnecrDB();

		
		assertNotNull(result);
	}

	
	@Test
	public void testConnecrDB_3()
		throws Exception {

		Connection result = javaconnect.ConnecrDB();

		
		assertNotNull(result);
	}


	@SuppressWarnings("unused")
	@Test
	public void testConnecrDB_4()
		throws Exception {

		Connection result = javaconnect.ConnecrDB();

		
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
		new org.junit.runner.JUnitCore().run(javaconnectTest.class);
	}
}