package loaders;

import utils.TitleStripper;

public class LinkLoader implements Loader {
	private String target;
	private String url;
	private String title;

	public String getUrl() { return url; }
	public String getTitle() { return title; }
	
	@Override
	public void setTarget(String target) { this.target = target; }

	@Override
	public String getTarget() { return target; }
	

	@Override
	public void load() {
		if (target != null) {
			getClipUrl(target);
		} else {
			System.out.println("LinkLoader target is null");
		}
	}
	
	public void getClipUrl(String clipped) {
		if (clipped.contains("http:") || clipped.contains("https:")) {
			url = clipped;
			
			// TitleExtractor will throw a NullPointerException
			// if it isn't a real URL, but does start with "http:" or "https:"
			getUrlTitle();		        
		} else {
			System.out.println("Alert: Warning - Empty Clipboard");
			/* TODO: ALERT MESSAGE - HANDLE IN PLATFORM AGNOSTIC MANNER
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning: Empty Clipboard");
			alert.setHeaderText("Clipboard does not contain a valid URL");
			alert.setContentText("Copy a URL from your browser and try again.");
			alert.showAndWait();
			*/
		}
	}
	
	private void getUrlTitle() {
		// TODO: PROBABLY NEED TO MAKE THIS RETURN STRING
		//		INSTEAD OF SETTING VARIABLE DIRECTLY
		try {
			TitleStripper stripper = new TitleStripper(url);
			title = stripper.getTitle();
		} catch (NullPointerException nullEx) {
			System.out.println("Alert: Warning - Address Invalid");
			/* TODO: ALERT MESSAGE - HANDLE IN PLATFORM AGNOSTIC MANNER
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning: Address Invalid");
			alert.setHeaderText("Clipboard does not contain a valid URL");
			alert.setContentText("Make sure you have a full web address copied.");
			alert.showAndWait();
			*/
			// Only allow file creation if the try was successful
			// otherwise empty out the title
			title = "";
		} 
	}

}
