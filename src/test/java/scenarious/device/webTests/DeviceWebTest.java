package scenarious.device.webTests;


import base.HooksRealDevice;
import base.WebTestBaseDevice;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.SUT_TITLE;
import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class DeviceWebTest extends HooksRealDevice {
    private WebTestBaseDevice webTestBase = new WebTestBaseDevice();

    protected DeviceWebTest() throws IOException {
        super();
    }

    @Test(description = "Check website")
    private void websiteTest() throws Exception {
        webTestBase.openSUT(SUT);
        webTestBase.driverWaitUntil(SUT);
        assertEquals(webTestBase.getSUTTitle(), SUT_TITLE);
        assertEquals(webTestBase.getHTTPStatusCode(SUT), HttpStatus.SC_OK);
        assertEquals(webTestBase.getSUTTitle(), SUT_TITLE);
    }
}