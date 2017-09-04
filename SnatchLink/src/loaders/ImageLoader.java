package loaders;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader implements Loader {
	private String target;
	private BufferedImage img = null;
	
	public BufferedImage getImage() {
		return img;
	}

	@Override
	public void setTarget(String target) {
		this.target = target;
	}

	@Override
	public String getTarget() {
		return target;
	}

	@Override
	public void load() {
		// Take a given String as a target location
		// and read it into a Buffered Image from the file system
		try {
			img = ImageIO.read(new File(getTarget()));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
