package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.ContactManagerPage;
import setup.RealDeviceDriverSetup;

import java.io.IOException;

/**
 * TearDown and SetUp procedures real device's tests
 */

public class HooksRealDevice extends RealDeviceDriverSetup {

    protected ContactManagerPage contactManagerPage;

    public HooksRealDevice() throws IOException {
        super();
    }

    @BeforeClass
    public void setUp() throws Exception {
        prepareDriver();
        contactManagerPage = PageFactory.initElements(driver(), ContactManagerPage.class);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver().quit();
    }
}
