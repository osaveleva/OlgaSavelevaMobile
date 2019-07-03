package base;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import setup.DriverSetup;

import java.io.IOException;

public class Hooks extends DriverSetup {
    AppiumDriver driver;

    protected Hooks() throws IOException {
        super();
    }

    @BeforeClass
    public void setUp() throws Exception {
        prepareDriver();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver().quit();
    }
}
