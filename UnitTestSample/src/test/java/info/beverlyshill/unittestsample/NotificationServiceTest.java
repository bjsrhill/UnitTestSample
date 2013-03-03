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
 * Test that subscribers are allowed to subscribe to start receiving messages
 * Test that subscribers allow to be unsubscribed to stop receiving messages
 * Test that every time a new message comes it should be sent to all subscribers
 * Test that only subscribers receive messages
 * Test that a subscriber cannot be subscribed more than once
 * Test that an unsubscribed subscriber does not continue receiving messages
 * @author bhill2
 */
public class NotificationServiceTest {
	//SUT
	private NotificationService notificationService = new NotificationService();
	
	//Subscriber
	private Subscriber subscriber = null;
	
	//Additional Subscriber instances
	private Subscriber firstSubscriber = null;
	private Subscriber secondSubscriber = null;
	
	//Message
	private Message message = null;
	
	@Before
	public void setUp() throws Exception {
		//Subscriber mock
		subscriber = Mockito.mock(Subscriber.class);
		//Additional Subscriber mocks
		firstSubscriber = Mockito.mock(Subscriber.class);
		secondSubscriber = Mockito.mock(Subscriber.class);
		//Message mock
		Message message = Mockito.mock(Message.class);
	}

	/**
	 * Test for addSubscriber
	 * Tests that the method 
	 */
	@Test
	public final void addedSubscriberSetsSubscriber() {
		//invoke test method - subscriber subscribes
		notificationService.addSubscriber(subscriber);
		//assert that test method sets subscriber name
		assertNotNull("The value is null and should not be null.", notificationService.getSubscriberName());
	}
	
	/**
	 * Test for send
	 * Tests that the method invokes subscriber.receive(message)
	 */
	@Test
	public final void sendMessageSubscriberShouldReceiveMessage() {
		//invoke method addSubscriber - subscriber subscribes
		notificationService.addSubscriber(subscriber);
		//invoke method to test
		notificationService.send(message);
		//verify that subscribed subscriber receives message
		Mockito.verify(subscriber).receive(message);
	}
	
	/**
	 * Test for send
	 * Test that all subscribed subscribers receive
	 * a message
	 */
	@Test
	public final void allSubscribedSubscribersReceibeMessage() {
		notificationService.addSubscriber(firstSubscriber);
		notificationService.addSubscriber(secondSubscriber);
		notificationService.send(message);
		Mockito.verify(firstSubscriber).receive(message);
		Mockito.verify(secondSubscriber).receive(message);
	}
	
	/**
	 * Test that subscribers not subscribed to not 
	 * receive messages
	 */
	@Test
	public void notSubscribedSubscriberDoesNotReceiveMessage() {
		notificationService.send(message);
		Mockito.verify(subscriber, Mockito.never()).receive(message);
	}
	
	/**
	 * Test that subscribers cannot be subscribed more
	 * than once
	 */
	@Test
	public void subscriberCannotSubscribeMoreThanOnce() {
		int numberTimesSubscribed = 2;
		for(int i = 0; i < numberTimesSubscribed; i++) {
			notificationService.addSubscriber(subscriber);
		}
		notificationService.send(message);
		Mockito.verify(subscriber).receive(message);
	}
	
	/**
	 * Test that unsubscribed subscribers no longer
	 * receive messages
	 */
	@Test
	public void unsubscribedSubscriberDoesNotReceiveMessages() {
		notificationService.addSubscriber(subscriber);
		notificationService.removeSubscriber(subscriber);
		notificationService.send(message);
		Mockito.verify(subscriber, Mockito.never()).receive(message);
	}
}
	
	
