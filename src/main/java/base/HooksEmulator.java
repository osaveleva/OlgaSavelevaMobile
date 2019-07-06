package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.ContactManagerPage;
import setup.DriverSetupEmulator;


import java.io.IOException;

/**
 * TearDown and SetUp procedures emulator's tests
 */

public class HooksEmulator extends DriverSetupEmulator {

    protected ContactManagerPage contactManagerPage;

    public HooksEmulator() throws IOException {
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
