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


    private String AUT;
    protected String SUT;
    private String TEST_PLATFORM;
    private String DRIVER;
    private String DEVICE_NAME_EMULATOR;
    private String APPACTIVITY_VALUE;
    private String DEVICE_NAME;


    protected DriverSetup() throws IOException {
        AUT = getProp("aut");
        TEST_PLATFORM = getProp("platformName");
        SUT = getProp("sut");
        DRIVER = getProp("driver");
        DEVICE_NAME_EMULATOR = getProp("deviceNameEmulator");
        DEVICE_NAME = getProp("deviceName");
        APPACTIVITY_VALUE = getProp("appactivity");
    }

    protected void prepareDriver() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        String browserName;


        switch (TEST_PLATFORM) {
            case PLATFORM_ANDROID:
                if (DEVICE_NAME_EMULATOR != null && DEVICE_NAME == null)
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME_EMULATOR);
                else if (DEVICE_NAME_EMULATOR == null && DEVICE_NAME != null)
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
