/**
 * 
 */
package info.beverlyshill.unittestsample;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.stereotype.Component;

/**
 * Service that manages scribing and notifying subscribers
 * Subscribers are allowed to subscribe to start receiving messages
 * Subscribers allow to be unsubscribed to stop receiving messages
 * Every time a new message comes it should be sent to all subscribers
 * @author bhill2
 */
@Component
public class NotificationService {
	
	private Subscriber subscriber;
	
	private Collection<Subscriber> allSubscribers = new HashSet<Subscriber>();

	/**
	 * Subscribes a subscriber
	 * @param subscriber is a Subscriber object
	 */
	public void addSubscriber(Subscriber subscriber) {
		allSubscribers.add(subscriber);
		this.subscriber = subscriber;
		
	}

	/**
	 * Sends a message to a subscriber
	 * @param message
	 */
	public void send(Message message) {
		for(Subscriber subscriber : allSubscribers) {
			subscriber.receive(message);
		}
	}
	
	/**
	 * Returns a Subscriber object
	 * @return a Subscriber object
	 */
	public Subscriber getSubscriberName() {
		return this.subscriber;
	}

	/**
	 * Unsubscribes a Subscriber
	 * 
	 * @param subscriberToRemove is a Subscriber object
	 * @return true if the subscriber is unsubscribed and
	 * false if the subscriber is not unsubscribed
	 */
	public boolean removeSubscriber(Subscriber subscriberToRemove) {
		return this.allSubscribers.remove(subscriberToRemove);
	}
}
