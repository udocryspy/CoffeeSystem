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


public class LoginTest {
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	@Test
	public void testLogin_1()
		throws Exception {

		Login result = new Login();

		
		assertNotNull(result);
	}

	
	@Test
	public void testLoginScreen_1()
		throws Exception {
		conn=javaconnect.ConnecrDB();
		Login fixture = new Login();
		//fixture.pst = new PreparedStatement(new pst ("", ""), "");
		//fixture.conn = new connection ("", "");
		//fixture.rs = new rs();

		fixture.LoginScreen();

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
		new org.junit.runner.JUnitCore().run(LoginTest.class);
	}
}