package Test;

import AppiumSupport.AppiumBaseClass;
import PageObjects.*;
import org.junit.After;
import org.junit.Before;

import AppiumSupport.AppiumController;

/**
 * Created by Andrej on Jun 2017.
 */
public class BaseTestClass extends AppiumBaseClass{
    
	protected InitialPage initialPage;
	protected AlertViewsPage alertViewsPage;
	
    @Before
    public void setUp() throws Exception {
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID:
                initialPage = new InitialPageAndroid(driver());
                alertViewsPage = new AlertViewsPageAndroid(driver());
                break;
            case IOS:
                initialPage = new InitialPageIOS(driver());
                alertViewsPage = new AlertViewsPageIOS(driver());
                break;
        }
    }

    @After
    public void tearDown() {
        AppiumController.instance.stop();
    }
}
