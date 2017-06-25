package PageObjects;

import io.appium.java_client.MobileElement;

/**
 * Created by Created by Andrej on Jun 2017.
 */
public interface AlertViewsPage {

	public void openTextEntryPage();
	public void openSecureTextEntryPage();
	public MobileElement getSecureTextFromButton();
	public MobileElement getTitlePage();
	public void entryText(String text);
	public void clickOKButton();

}
