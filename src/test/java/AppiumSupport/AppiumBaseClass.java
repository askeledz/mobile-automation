package AppiumSupport;

import io.appium.java_client.AppiumDriver;

/**
 * Created by Andrej on Jun 2017.
 */
public abstract class AppiumBaseClass {

    protected AppiumDriver driver() {
        return AppiumController.instance.driver;
    }
}
