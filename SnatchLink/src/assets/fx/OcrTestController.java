package assets.fx;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class OcrTestController {
	// Main pane
	public BorderPane borderPane;

	// Menu Items
	public MenuItem menuOpenImage;
	
	// Views
	public TreeView<String> treeView;
	public WebView webView;
	public ImageView imgView;
	
	// Buttons
	public Button btnGetLink;
	public Button btnOpenLink;
	public Button btnOpenInBrowser;
	public Button btnSnipFromWeb;
	
	
	// Call dialog for selecting an image file on the file system
	public String openImage() {
		String imgLocation = null;
		
		try {
			// Opens a file chooser dialog
			imgLocation = getImageLocation();
			// Includes path and full name, as well as extension
			
			// Make sure file exists still and set the ImageView to that picture
			File file = new File(imgLocation);
			if (file != null && file.exists()) {
				Image image = new Image(file.toURI().toString());
				imgView.setImage(image);
			}
		} catch (NullPointerException ex) {
			// If file chooser is canceled out of
			System.out.println("Exception reached: " + ex);
		}
		return imgLocation;
	}
	
	// openImage uses this function to open a FileChooser
	// with an extensions filtered
	public String getImageLocation() {
		String imgLocation = null;
		
		try {
			ExtensionFilter extFilter = new ExtensionFilter("Images", "*.png", "*.jpg", "*.bmp");
			//"Web pages", "*.tpl", "*.html", "*.htm"
			
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Image for Processing");
			fileChooser.getExtensionFilters().add(extFilter);
			
			Stage stage = (Stage) borderPane.getScene().getWindow();
			File file = fileChooser.showOpenDialog(stage);
			
			// Want to return a string that openImage() can use as a URI
			// instead of the file itself
			imgLocation = file.getAbsolutePath();
		}
		catch (NullPointerException ex) {
			System.out.println("Caught a null pointer exception: " + ex);
		}
		
		catch (Exception ex) {
			System.out.println("Exception reached: " + ex);
		}
		
		return imgLocation;
	}
	
	// Start process for getting a link from an image
	public String getLink() {
		String link = null;
		
		link = "I'm a link, baby!";
		
		return link;
	}
}
