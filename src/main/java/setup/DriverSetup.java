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

/**
 * Prepare driver and set desired capabilities for emulator's tests
 */

public class DriverSetup extends TestProperties {
    private static WebDriverWait waitSingle;
    private static AppiumDriver driverSingle = null;


    protected String SUT;


    public DriverSetup()  {
    }

    protected void prepareDriver() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        String browserName;
        String AUT = getProp("aut");
        String TEST_PLATFORM = getProp("platformName");
        SUT = getProp("sut");
        String DRIVER = getProp("driver");
        String DEVICE_NAME = getProp("deviceName");
        String APPACTIVITY_VALUE = getProp("appactivity");


        switch (TEST_PLATFORM) {
            case PLATFORM_ANDROID:
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = BROWSERCHROME.getRecord();
                break;
            case PLATFORM_iOS:
                browserName = BROWSERSAFARI.getRecord();
                break;
            default:
                throw new Exception("Unknown mobile paltform");
        }
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            //cap.setCapability("autoLaunch","false");
        } else if (SUT != null && AUT == null) {
            cap.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
            cap.setCapability(APPACTIVITY.getRecord(), APPACTIVITY_VALUE);
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
