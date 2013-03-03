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
 * 
 * Test that clients are allowed to subscribe to start receiving messages
 * Test that subscribers allow to be unsubscribed to stop receiving messages
 * Test that every time a new message comes it should be sent to all subscribers
 * Test that only subscribers receive messages
 * Test that a client cannot be subscribed more than once
 * Test that an unsubscribed client does not continue receiving messages
 * @author bhill2
 */
public class NotificationServiceTest {
	//SUT
	private NotificationService notificationService = new NotificationService();
	
	//Client
	private Client client = null;
	
	//Additional Client instances
	private Client firstSubscriber = null;
	private Client secondSubscriber = null;
	
	//Message
	private Message message = null;
	
	@Before
	public void setUp() throws Exception {
		//Client mock
		client = Mockito.mock(Client.class);
		//Additional Client mocks
		firstSubscriber = Mockito.mock(Client.class);
		secondSubscriber = Mockito.mock(Client.class);
		//Message mock
		Message message = Mockito.mock(Message.class);
	}

	/**
	 * Test for addSubscriber
	 * Tests that the method 
	 */
	@Test
	public final void addedSubscriberSetsClient() {
		//invoke test method - client subscribes
		notificationService.addSubscriber(client);
		//assert that test method sets client name
		assertNotNull("The value is null and should not be null.", notificationService.getClientName());
	}
	
	/**
	 * Test for send
	 * Tests that the method invokes client.receive(message)
	 */
	@Test
	public final void sendMessageClientShouldReceiveMessage() {
		//invoke method addSubscriber - client subscribes
		notificationService.addSubscriber(client);
		//invoke method to test
		notificationService.send(message);
		//verify that subscribed client receives message
		Mockito.verify(client).receive(message);
	}
	
	/**
	 * Test for send
	 * Test that all subscribed clients receive
	 * a message
	 */
	@Test
	public final void allSubscribedClientsReceibeMessage() {
		notificationService.addSubscriber(firstSubscriber);
		notificationService.addSubscriber(secondSubscriber);
		notificationService.send(message);
		Mockito.verify(firstSubscriber).receive(message);
		Mockito.verify(secondSubscriber).receive(message);
	}
	
	/**
	 * Test that clients not subscribed to not 
	 * receive messages
	 */
	@Test
	public void notSubscribedClientDoesNotReceiveMessage() {
		notificationService.send(message);
		Mockito.verify(client, Mockito.never()).receive(message);
	}
	
	/**
	 * Test that clients cannot be subscribed more
	 * than once
	 */
	@Test
	public void clientCannotSubscribeMoreThanOnce() {
		int numberTimesSubscribed = 2;
		for(int i = 0; i < numberTimesSubscribed; i++) {
			notificationService.addSubscriber(client);
		}
		notificationService.send(message);
		Mockito.verify(client).receive(message);
	}
	
	/**
	 * Test that unsubscribed clients no longer
	 * receive messages
	 */
	@Test
	public void unsubscribedClientDoesNotReceiveMessages() {
		notificationService.addSubscriber(client);
		notificationService.removeSubscriber(client);
		notificationService.send(message);
		Mockito.verify(client, Mockito.never()).receive(message);
	}
}
	
	
