package scenarious.mobileTests.webTests;


import base.Hooks;
import base.WebTestBase;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.*;
import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class WebTest extends Hooks {
    private WebTestBase webTestBase = new WebTestBase();

    protected WebTest() throws IOException {
        super();
    }

    @Test(description = "Check website", groups = "emulatorWeb, deviceWeb")
    private void websiteTest() throws Exception {
        webTestBase.openSUT(SUT);
        webTestBase.driverWaitUntil(SUT);
        assertEquals(webTestBase.getSUTTitle(), SUT_TITLE.getRecord());
        assertEquals(webTestBase.getHTTPStatusCode(SUT), HttpStatus.SC_OK);
        assertEquals(webTestBase.getSUTTitle(), SUT_TITLE.getRecord());
    }

}