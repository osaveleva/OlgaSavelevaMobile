package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import setup.RealDeviceDriverSetup;

import java.io.IOException;

public class HooksRealDevice extends RealDeviceDriverSetup {

    protected NativeTestBase nativeTestBase;

    public HooksRealDevice() throws IOException {
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
