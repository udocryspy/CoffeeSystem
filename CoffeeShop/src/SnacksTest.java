import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Component;

import net.proteanit.sql.DummySimplest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sqlite.SQLiteConnection;
import org.sqlite.jdbc4.JDBC4PreparedStatement;

public class SnacksTest {
	
	@Test
	public void testSnacks_1()
		throws Exception {

		Snacks result = new Snacks();

		// add additional test code here
		assertNotNull(result);
		assertEquals(new Integer(0), result.getMyValue());
	}

	
	@Test
	public void testSnackScreen_1()
		throws Exception {
		Snacks fixture = new Snacks();
	
		fixture.qC = 1;
		fixture.rs = new DummySimplest();
		fixture.qT = 1;
		fixture.Chicken = 1;
		fixture.Tuna = 1;
		

		fixture.SnackScreen();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsatisfiedLinkError: org.sqlite.NativeDB._open(Ljava/lang/String;I)V
		//       at org.sqlite.NativeDB._open(Native Method)
		//       at org.sqlite.DB.open(DB.java:157)
		//       at org.sqlite.SQLiteConnection.open(SQLiteConnection.java:184)
		//       at org.sqlite.SQLiteConnection.<init>(SQLiteConnection.java:105)
		//       at org.sqlite.SQLiteConnection.<init>(SQLiteConnection.java:82)
	}

	
	@Test
	public void testGetMyValue_1()
		throws Exception {
		Snacks fixture = new Snacks();
		fixture.conn = new SQLiteConnection("", "");
		fixture.qC = 1;
		fixture.rs = new DummySimplest();
		fixture.qT = 1;
		fixture.Chicken = 1;
		fixture.Tuna = 1;
		fixture.pst = new JDBC4PreparedStatement(new SQLiteConnection("", ""), "");

		Integer result = fixture.getMyValue();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsatisfiedLinkError: org.sqlite.NativeDB._open(Ljava/lang/String;I)V
		//       at org.sqlite.NativeDB._open(Native Method)
		//       at org.sqlite.DB.open(DB.java:157)
		//       at org.sqlite.SQLiteConnection.open(SQLiteConnection.java:184)
		//       at org.sqlite.SQLiteConnection.<init>(SQLiteConnection.java:105)
		//       at org.sqlite.SQLiteConnection.<init>(SQLiteConnection.java:82)
		assertNotNull(result);
	}

	
	@Test
	public void testGetRootPane_1()
		throws Exception {
		Snacks fixture = new Snacks();
		fixture.conn = new SQLiteConnection("", "");
		fixture.qC = 1;
		fixture.rs = new DummySimplest();
		fixture.qT = 1;
		fixture.Chicken = 1;
		fixture.Tuna = 1;
		fixture.pst = new JDBC4PreparedStatement(new SQLiteConnection("", ""), "");

		Component result = fixture.getRootPane();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.UnsatisfiedLinkError: org.sqlite.NativeDB._open(Ljava/lang/String;I)V
		//       at org.sqlite.NativeDB._open(Native Method)
		//       at org.sqlite.DB.open(DB.java:157)
		//       at org.sqlite.SQLiteConnection.open(SQLiteConnection.java:184)
		//       at org.sqlite.SQLiteConnection.<init>(SQLiteConnection.java:105)
		//       at org.sqlite.SQLiteConnection.<init>(SQLiteConnection.java:82)
		assertNotNull(result);
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
		new org.junit.runner.JUnitCore().run(SnacksTest.class);
	}
}