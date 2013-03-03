/**
 * 
 */
package info.beverlyshill.unittestsample;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for NotificationService
 * @author bhill2
 */
public class NotificationServiceTest {

	/**
	 * Test for addSubscriber
	 * Tests that the method 
	 */
	@Test
	public final void addedSubscriberSetsClient() {
		//SUT
		NotificationService notificationService = new NotificationService();
		//Client mock
		Client client = Mockito.mock(Client.class);
		//invoke test method
		notificationService.addSubscriber(client);
		//assert that test method sets client name
		assertNotNull("", notificationService.getClientName());
	}
	
	/**
	 * Test for send
	 * Tests that the method invokes client.receive(message)
	 */
	@Test
	public final void sendShouldSubscribedClientShouldReceiveMessage() {
		//SUT
		NotificationService notificationService = new NotificationService();
		//Client mock
		Client client = Mockito.mock(Client.class);
		//Message mock
		Message message = Mockito.mock(Message.class);
		//invoke method addSubscriber to set Client
		notificationService.addSubscriber(client);
		//invoke method to test
		notificationService.send(message);
		//verify that subscribed client receives message
		Mockito.verify(client).receive(message);
	}

}
