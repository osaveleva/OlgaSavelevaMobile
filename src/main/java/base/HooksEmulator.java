package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import setup.DriverSetupEmulator;


import java.io.IOException;

public class HooksEmulator extends DriverSetupEmulator {

    protected NativeTestBase nativeTestBase;

    public HooksEmulator() throws IOException {
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
}
