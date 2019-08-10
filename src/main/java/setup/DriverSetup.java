package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static constants.MobileTestingConstants.*;
import static constants.PlatformConstants.*;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;

/**
 * Prepare driver and set desired capabilities for emulator's tests
 */

public class DriverSetup extends TestProperties {
    private static WebDriverWait waitSingle;
    private static AppiumDriver driverSingle = null;
    protected static String SUT;

    protected void prepareDriver() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        String browserName;
        String AUT = getProp("aut");
        String TEST_PLATFORM = getProp("platformName");
        SUT = getProp("sut");
        String DRIVER = getProp("driver");
        String UDID_VALUE = getProp("udid");
        String APPACTIVITY_VALUE = getProp("appPackage");
        String APPPACKAGE_VALUE = getProp("appactivity");


        switch (TEST_PLATFORM) {
            case TEST_PLATFORM_ANDROID:
                browserName = BROWSERCHROME.getRecord();
                break;
            case TEST_PLATFORM_IOS:
                browserName = BROWSERSAFARI.getRecord();
                break;
            default:
                throw new Exception("Unknown mobile paltform");
        }
        cap.setCapability(UDID, UDID_VALUE);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            //    cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            cap.setCapability(APPPACKAGE.getRecord(), APPPACKAGE_VALUE);
            cap.setCapability(APPACTIVITY.getRecord(), APPACTIVITY_VALUE);
        } else if (SUT != null && AUT == null) {
            cap.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        //Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(DRIVER), cap);
        //Set an object to handle timeouts
        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }

}
