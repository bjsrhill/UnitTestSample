/**
 * 
 */
package info.beverlyshill.unittestsample;

import java.util.ArrayList;
import java.util.Collection;

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
	
	private Collection<Client> allClients = new ArrayList<Client>();

	public void addSubscriber(Client client) {
		allClients.add(client);
		this.client = client;
		
	}

	public void send(Message message) {
		for(Client client : allClients) {
			client.receive(message);
		}
	}
	
	public Client getClientName() {
		return this.client;
	}
}
