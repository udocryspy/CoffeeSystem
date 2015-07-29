

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	FeedbackTest.class,
	RegisterTest.class,
	
})
public class FdbackRegTestSuite {


	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { FdbackRegTestSuite.class });
	}
}