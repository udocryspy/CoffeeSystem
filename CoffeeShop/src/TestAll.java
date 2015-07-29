

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	MainTest.class,
	CustomerTest.class,
	AdminTest.class,
	javaconnectTest.class,
	LoginTest.class,
})
public class TestAll {

	
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}