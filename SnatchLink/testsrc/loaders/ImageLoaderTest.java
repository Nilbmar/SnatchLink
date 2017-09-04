package loaders;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

public class ImageLoaderTest {
	
	private ImageLoader classUnderTest;
	private String target = null;

	@Before
	public void setUp() throws Exception {
		classUnderTest = new ImageLoader();
	}
	
	public void testSetTarget(String target) {
		this.target = target;
	}
	
	public String testGetTarget() {
		return target;
	}

	@Test
	public void testLoad() {
		/*
		// Should fail due to target not being set
		testSetTarget(null);	

		classUnderTest.setTarget(testGetTarget());
		classUnderTest.load();

		assertNotNull("target is null", classUnderTest.getTarget());
		assertNotNull("BufferedImage is null", classUnderTest.getImage());
		*/
		
		/*
		// Should fail due to img not being set
		testSetTarget("/home/sysgeek/git/ocr/SnatchLink/src/assets/images/orc_test_link.png");		
		
		assertNotNull("target is null", classUnderTest.getTarget());
		assertNotNull("BufferedImage is null", classUnderTest.getImage());
		*/		
				
		// Legitimate test - should pass
		testSetTarget("/home/sysgeek/git/ocr/SnatchLink/src/assets/images/orc_test_link.png");
		
		classUnderTest.setTarget(testGetTarget());
		classUnderTest.load();

		assertNotNull("target is null", classUnderTest.getTarget());
		assertNotNull("BufferedImage is null", classUnderTest.getImage());
	}

}
