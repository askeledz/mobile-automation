package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Created by Andrej on Jun 2017.
 */
public class AlertViewsPageAndroid implements AlertViewsPage {

    public AlertViewsPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //FindBy XPATH
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Text Entry']")
    public MobileElement textEntry;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Secure Text Entry']")
    public MobileElement secureTextEntry;
    
    @FindBy(xpath = "//XCUIElementTypeTextField")
    public MobileElement alertTextBox;
    
    @FindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeButton")
    public MobileElement okButton;

    //FindBy id
    @FindBy(id = "Alert Views")
    public MobileElement titlePage;
    
    public void openTextEntryPage() {
        textEntry.click();
    }
    
    public void openSecureTextEntryPage() {
        secureTextEntry.click();
    }

    public void entryText(String text) {
    	alertTextBox.sendKeys(text);
    }
    
    public void clickOKButton() {
    	okButton.click();
    }
    
    public MobileElement getSecureTextFromButton() {
        return secureTextEntry;
    }
    
    public MobileElement getTitlePage() {
        return titlePage;
    }
    
}
