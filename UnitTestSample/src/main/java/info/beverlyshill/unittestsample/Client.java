/**
 * 
 */
package info.beverlyshill.unittestsample;

import org.springframework.stereotype.Component;

/**
 * @author bhill2
 *
 */
@Component
public interface Client {

	void receive(Message message);
	void setClientName(Client client);
	Client getClientName();

}
