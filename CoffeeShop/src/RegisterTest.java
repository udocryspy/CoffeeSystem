import static org.junit.Assert.assertNotNull;

import javax.swing.JComboBox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sqlite.SQLiteConnection;
import org.sqlite.jdbc4.JDBC4PreparedStatement;

public class RegisterTest {
	
	@Test
	public void testRegister_1()
		throws Exception {

		Register result = new Register();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsatisfiedLinkError: org.sqlite.NativeDB._open(Ljava/lang/String;I)V
		//       at org.sqlite.NativeDB._open(Native Method)
		//       at org.sqlite.DB.open(DB.java:157)
		//       at org.sqlite.SQLiteConnection.open(SQLiteConnection.java:184)
		//       at org.sqlite.SQLiteConnection.<init>(SQLiteConnection.java:105)
		//       at org.sqlite.JDBC.createConnection(JDBC.java:113)
		//       at org.sqlite.JDBC.connect(JDBC.java:87)
		//       at java.sql.DriverManager.getConnection(Unknown Source)
		//       at java.sql.DriverManager.getConnection(Unknown Source)
		//       at javaconnect.ConnecrDB(javaconnect.java:15)
		//       at Register.<init>(Register.java:51)
		assertNotNull(result);
	}

		@SuppressWarnings("rawtypes")
	@Test
	public void testRegistrationScreen_1()
		throws Exception {
		Register fixture = new Register();
		fixture.setCbgender(new JComboBox());
		

		fixture.RegistrationScreen();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsatisfiedLinkError: org.sqlite.NativeDB._open(Ljava/lang/String;I)V
		//       at org.sqlite.NativeDB._open(Native Method)
		//       at org.sqlite.DB.open(DB.java:157)
		//       at org.sqlite.SQLiteConnection.open(SQLiteConnection.java:184)
		//       at org.sqlite.SQLiteConnection.<init>(SQLiteConnection.java:105)
		//       at org.sqlite.JDBC.createConnection(JDBC.java:113)
		//       at org.sqlite.JDBC.connect(JDBC.java:87)
		//       at java.sql.DriverManager.getConnection(Unknown Source)
		//       at java.sql.DriverManager.getConnection(Unknown Source)
		//       at javaconnect.ConnecrDB(javaconnect.java:15)
		//       at Register.<init>(Register.java:51)
	}

	
	
	@Test
	public void testGetCbgender_1()
		throws Exception {
		Register fixture = new Register();
		fixture.setCbgender(new JComboBox());
	

		JComboBox result = fixture.getCbgender();

		
		assertNotNull(result);
	}

	
	@SuppressWarnings("rawtypes")
	@Test
	public void testSetCbgender_1()
		throws Exception {
		Register fixture = new Register();
		fixture.setCbgender(new JComboBox());
		
		JComboBox cbgender = new JComboBox();

		fixture.setCbgender(cbgender);

		
	}

	
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(RegisterTest.class);
	}
}