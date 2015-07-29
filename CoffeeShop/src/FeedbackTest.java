import static org.junit.Assert.assertNotNull;
import net.proteanit.sql.DummySimplest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sqlite.SQLiteConnection;

public class FeedbackTest {
	
	@Test
	public void testFeedback_1()
		throws Exception {

		Feedback result = new Feedback();

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
		//       at Feedback.<init>(Feedback.java:48)
		assertNotNull(result);
	}

	@Test
	public void testFeedbackScreen_1()
		throws Exception {
		Feedback fixture = new Feedback();
	//	fixture.conn = new SQLiteConnection("", "");
		fixture.rs = new DummySimplest();

		fixture.FeedbackScreen();

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
		//       at Feedback.<init>(Feedback.java:48)
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
		new org.junit.runner.JUnitCore().run(FeedbackTest.class);
	}
}