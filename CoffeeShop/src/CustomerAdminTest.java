

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	CustomerTest.class,
	AdminTest.class,
})
public class CustomerAdminTest {

	
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { CustomerAdminTest.class });
	}
}