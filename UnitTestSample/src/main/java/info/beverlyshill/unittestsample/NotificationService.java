/**
 * 
 */
package info.beverlyshill.unittestsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author bhill2
 *
 */
@Component
public class NotificationService implements Message, Client {
	
	private Client client;

	public void addSubscriber(Client client) {
		this.client = client;
		setClientName(this.client);
		
	}

	public void send(Message message) {
		this.receive(message);	
	}
	
	public void setClientName(Client client) {
		client.setClientName(client);
	}
	
	public Client getClientName() {
		return this.client;
	}

	@Override
	public void receive(Message message) {
		client.receive(message);
		
	}

}
