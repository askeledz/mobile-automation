package Test;

import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Andrej Skeledzija on Jun 2017.
 */
public class SmokeUITests extends BaseTestClass {

    @Test
    public void shouldOpenAlertViewsPageTest() throws InterruptedException {
          //Search for contact
          initialPage.openAlertViews();
          
          //Verify page is open
          MobileElement getTitlePage = alertViewsPage.getTitlePage();
          Assert.assertEquals("Alert Views", getTitlePage.getText());
          
          alertViewsPage.openTextEntryPage();
          alertViewsPage.entryText("F I L I P");
          alertViewsPage.clickOKButton();
         
          //Verify result
          MobileElement getTextFromButton = alertViewsPage.getSecureTextFromButton();
          Assert.assertEquals("Secure Text Entry", getTextFromButton.getText());
          
    }
}
