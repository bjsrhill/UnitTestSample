package info.beverlyshill.unittestsample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

public class HomeControllerTest {
	
	private HomeController homeController = new HomeController();

	/**
	 * Test for home
	 * Tests that when the home method is invoked from a GET request the
	 * expected view is returned
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testHome() {
		ExtendedModelMap uiModel = new ExtendedModelMap();
		Locale locale = new Locale("en","US"); 
		String v = homeController.home(locale, uiModel);
		assertNotNull(v);
		assertEquals("Expected view was not returned.","home", v);
	}
}
