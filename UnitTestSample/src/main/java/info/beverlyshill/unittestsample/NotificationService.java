/**
 * 
 */
package info.beverlyshill.unittestsample;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.stereotype.Component;

/**
 * Service that manages scribing and notifying clients
 * Clients are allowed to subscribe to start receiving messages
 * Subscribers allow to be unsubscribed to stop receiving messages
 * Every time a new message comes it should be sent to all subscribers
 * @author bhill2
 */
@Component
public class NotificationService {
	
	private Client client;
	
	private Collection<Client> allClients = new HashSet<Client>();

	/**
	 * Subscribes a client
	 * @param client is a Client object
	 */
	public void addSubscriber(Client client) {
		allClients.add(client);
		this.client = client;
		
	}

	/**
	 * Sends a message to a client
	 * @param message
	 */
	public void send(Message message) {
		for(Client client : allClients) {
			client.receive(message);
		}
	}
	
	/**
	 * Returns a Client object
	 * @return a Client object
	 */
	public Client getClientName() {
		return this.client;
	}

	/**
	 * Unsubscribes a Client
	 * 
	 * @param clientToRemove is a Client object
	 */
	public void removeSubscriber(Client clientToRemove) {
		this.allClients.remove(clientToRemove);
	}
}
