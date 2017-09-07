package assets.fx;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import loaders.ImageLoader;
import loaders.LinkLoader;

public class OcrTestController {
	// Main pane
	public BorderPane borderPane;

	// Menu Items
	public MenuItem menuOpenImage;
	
	// Views
	public TreeView<String> treeView;
	public ImageView imgView;
	public WebView webView;
	public WebEngine webEngine;
	
	// Buttons
	public Button btnProcessLink;
	public Button btnOpenLink;
	public Button btnOpenInBrowser;
	public Button btnSnipFromWeb;
	public Button btnTestLinkLoader;
	
	public Label lblInfo;
	

	private ImageLoader imageLoader;
	private LinkLoader linkLoader;
	private String link = null;
	private String info = null;

	// Call dialog for selecting an image file on the file system
	// then shows the selected image in the ImageView
	public void openImage() {
		// Make sure the imageLoader is created
		if (imageLoader == null) {
			imageLoader = new ImageLoader();
		}
		
		try {
			// Opens a file chooser dialog
			// and uses the return value to set a target image
			// to be used in the ImageView
			imageLoader.setTarget(getImageLocation());
			// Includes path and full name, as well as extension
			
			// Make sure file exists still and set the ImageView to that picture
			File file = new File(imageLoader.getTarget());
			if (file != null && file.exists()) {
				Image image = new Image(file.toURI().toString());
				imgView.setImage(image);
			}
		} catch (NullPointerException ex) {
			// If file chooser is canceled out of
			System.out.println("Exception reached: " + ex);
		}
		
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
	
	public ImageLoader getImageLoader() { return imageLoader; }
	
	// Start process for getting a link from an image
	public void processLink() {
		// TODO: THIS IS WHERE THE OCR CODE WILL GO
		setLink("http://www.java2s.com/Tutorials/Java/JavaFX/1510__JavaFX_WebView.htm");
	}
	
	public void openLink() {
		// Create the engine for webView to use
		// if it doesn't already exist
		if (webEngine == null) {
			webEngine = webView.getEngine();
		}
		
		// Open web page in webView if engine and link exist
		if (link != null && webEngine != null) {
			webEngine.load(link);
		} else {
			System.out.println("Still need to process a link.");
		}
	}
	
	public String getLink() { return link; }
	public void setLink(String link) { this.link = link; }
	public LinkLoader getLinkLoader() { return linkLoader; }
	
	public void testLinkLoader() {
		if (linkLoader == null) {
			linkLoader = new LinkLoader();
		}
		
		linkLoader.setTarget("http://musicforprogramming.net/?thirtyeight");
		linkLoader.load();
		
		if (linkLoader.getUrl() != null && linkLoader.getTitle() != null) {
			setLink(linkLoader.getUrl());
			openLink();
			setInfoLabel(linkLoader.getTitle());
		}
	}
	
	public void setInfoLabel(String info) { 
		this.info = info; 
		lblInfo.setText(this.info);
	}
	
}
