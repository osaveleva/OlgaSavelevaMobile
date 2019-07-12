package scenarious.mobilecloud.webTests;


import base.HooksCloud;
import base.WebTestBaseEmulator;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.SUT_TITLE;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class CloudWebTest extends HooksCloud {
    private WebTestBaseEmulator webTestBaseEmulator = new WebTestBaseEmulator();

    protected CloudWebTest() throws IOException {
        super();
    }

    @Test(description = "Check website")
    protected void websiteTest() throws Exception {
        webTestBaseEmulator.openSUT(SUT);
        webTestBaseEmulator.driverWaitUntil(SUT);
        //Print site title to check that correst sut is opened
        System.out.println("Print site title "+webTestBaseEmulator.getSUTTitle());
        assertEquals(webTestBaseEmulator.getSUTTitle(), SUT_TITLE);
        assertEquals(webTestBaseEmulator.getHTTPStatusCode(SUT), SC_OK);
        assertEquals(webTestBaseEmulator.getSUTTitle(), SUT_TITLE);
    }
}