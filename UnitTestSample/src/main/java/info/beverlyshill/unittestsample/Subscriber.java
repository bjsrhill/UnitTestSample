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
public interface Subscriber {

	void receive(Message message);
	void setSubscriberName(Subscriber scriber);
	Subscriber getSubscriberName();

}
