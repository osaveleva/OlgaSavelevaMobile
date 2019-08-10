package base;

import constants.PropertyFile;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pageObjects.Calculator;
import setup.DriverSetup;

import java.io.IOException;

/**
 * TearDown and SetUp procedures emulator's tests
 */

public class Hooks extends DriverSetup {

    protected Calculator calculator;

    public Hooks() throws IOException {
        super();
    }

    @BeforeSuite (groups = {"native"})
    public void setNative() throws Exception {
        setpropertyFile(PropertyFile.NATIVE);
        prepareDriver();
        calculator = PageFactory.initElements(driver(), Calculator.class);
    }

    @BeforeSuite (groups = {"web"})
    public void setWeb() throws Exception {
        setpropertyFile(PropertyFile.WEB);
        prepareDriver();
        calculator = PageFactory.initElements(driver(), Calculator.class);
    }

    @AfterSuite( groups = {"native","web"})
    public void tearDown() throws Exception {
        driver().closeApp();
    }
}
