/**
 * 
 */
package info.beverlyshill.unittestsample;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author bhill2
 *
 */
public class NotificationServiceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void subscribedClientShouldReceiveMessage() {
		NotificationService raceResults = new NotificationService();
		Client client = Mockito.mock(Client.class);
		Message message = Mockito.mock(Message.class);
		raceResults.addSubscriber(client);
		raceResults.send(message);
		Mockito.verify(client).receive(message);
	}

}
