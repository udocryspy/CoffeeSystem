

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	AdminTest.class,
	LoginTest.class,
})
public class AdminLoginTest {

	
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { AdminLoginTest.class });
	}
}