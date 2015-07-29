import static org.junit.Assert.assertNotNull;
//import org.sqlite.SQLiteConnection;
//import org.sqlite.jdbc4.JDBC4PreparedStatement;
//import org.sqlite.JDBC

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
//import net.proteanit.sql.DummySimplest;
import org.junit.Test;


public class CustomerTest {
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	@Test
	public void testCustomer_1()
		throws Exception {

		Customer result = new Customer();

		
		assertNotNull(result);
	}

	
	@Test
	public void testCustomerScreen_1()
		throws Exception {
		conn=javaconnect.ConnecrDB();
		Customer fixture = new Customer();
		fixture.qA = 1;
		//fixture.pst = new JDBC4PreparedStatement(new c("", ""), "");
		fixture.qR = 1;
		fixture.Robusta = 1;
		//fixture.conn = new SQLiteConnection("", "");
		fixture.Total = 1;
		fixture.custno = 1;
		fixture.Arabica = 1;

		fixture.CustomerScreen();

		
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
		new org.junit.runner.JUnitCore().run(CustomerTest.class);
	}
}