package base;

import constants.PropertyFile;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageObjects.ContactManagerPage;
import setup.DriverSetup;


import java.io.IOException;

/**
 * TearDown and SetUp procedures for web and native tests
 */

public class Hooks extends DriverSetup {

    protected static ContactManagerPage contactManagerPage;


    @BeforeSuite(groups = {"native"})
    public void setNative() throws Exception {
        setpropertyFile(PropertyFile.NATIVE);
        prepareDriver();
        contactManagerPage = PageFactory.initElements(driver(), ContactManagerPage.class);
    }

    @BeforeSuite(groups = {"web"})
    public void setWeb() throws Exception {
        setpropertyFile(PropertyFile.WEB);
        prepareDriver();
    }

    @AfterSuite(groups = {"web", "native"}, description = "Close driver on all tests comletion")
    public void tearDown() throws Exception {
        driver().closeApp();
    }
}
