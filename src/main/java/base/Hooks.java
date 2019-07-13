package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

    @BeforeClass
    public void setUp() throws Exception {
        prepareDriver();
        calculator = PageFactory.initElements(driver(), Calculator.class);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver().quit();
    }
}
