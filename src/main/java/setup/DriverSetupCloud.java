package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static constants.MobileTestingConstants.*;

/**
 * Prepare driver and set desired capabilities for emulator's tests
 */

public class DriverSetupCloud extends TestProperties {
    private static WebDriverWait waitSingle;
    private static AppiumDriver driverSingle = null;

    private String AUT;
    protected String SUT;
    private String TEST_PLATFORM;
    private String DRIVER;
    private String DEVICE_NAME;
    private String APPACTIVITY_VALUE;
    private String UDID_VALUE;
    private String APPPACKAGE_VALUE;


    protected DriverSetupCloud() throws IOException {
        AUT = getProp("aut");
        TEST_PLATFORM = getProp("platformName");
        SUT = getProp("sut");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("deviceName");
        APPACTIVITY_VALUE = getProp("appactivity");
        UDID_VALUE = getProp("udid");
        APPPACKAGE_VALUE = getProp("appPackage");
    }

    protected void prepareDriver() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        String browserName;

        switch (TEST_PLATFORM) {
            case TEST_PLATFORM_ANDROID:
             //   cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                cap.setCapability(UDID, UDID_VALUE);
                browserName = BROWSERCHROME;
                break;
            case TEST_PLATFORM_IOS:
                browserName = BROWSERSAFARI;
               // cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                cap.setCapability(UDID, UDID_VALUE);
                break;
            default:
                throw new Exception("Unknown mobile paltform");
        }
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            //cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            cap.setCapability(APPPACKAGE, APPPACKAGE_VALUE);
            cap.setCapability(APPACTIVITY, APPACTIVITY_VALUE);
        } else if (SUT != null && AUT == null) {
            cap.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
            cap.setCapability(APPACTIVITY, APPACTIVITY_VALUE);
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