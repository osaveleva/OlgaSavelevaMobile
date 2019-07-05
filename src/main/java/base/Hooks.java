package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import setup.DriverSetup;

import java.io.IOException;

public class Hooks extends DriverSetup {
  //  AppiumDriver driver;
    protected NativeTestBase nativeTestBase;

    public Hooks() throws IOException {
        super();
    }

    @BeforeClass
    public void setUp() throws Exception {
        prepareDriver();
        nativeTestBase = PageFactory.initElements(driver(), NativeTestBase.class);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver().quit();
    }

    @BeforeMethod
    public void setUp2() throws Exception {
        driver().launchApp();
    }
}
