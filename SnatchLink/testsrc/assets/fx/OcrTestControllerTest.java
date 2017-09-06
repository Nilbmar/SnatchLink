package assets.fx;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OcrTestControllerTest {
	private OcrTestController controller;

	@Before
	public void setUp() throws Exception {
		controller = new OcrTestController();
	}

	// Commented out because I can't test FileChooser from the fxml
	//@Test
	public void testOpenImage() {
		System.out.println(controller.openImage());
		assertNotNull("Open Image returns null", controller.openImage());
	}
	
	@Test
	public void testGetLink() {
		System.out.println(controller.getLink());
		assertNotNull("Get Link returns null", controller.getLink());
	}

}
