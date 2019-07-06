package scenarious.emulators.webTests;


import base.HooksEmulator;
import base.WebTestBaseEmulator;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.SUT_TITLE;
import static org.apache.http.HttpStatus.*;
import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class FirstSimpleWebTest extends HooksEmulator {
    private WebTestBaseEmulator webTestBaseEmulator = new WebTestBaseEmulator();

    protected FirstSimpleWebTest() throws IOException {
        super();
    }

    @Test(description = "Check website")
    protected void websiteTest() throws Exception {
        webTestBaseEmulator.openSUT(SUT);
        webTestBaseEmulator.driverWaitUntil(SUT);
        assertEquals(webTestBaseEmulator.getSUTTitle(), SUT_TITLE);
        assertEquals(webTestBaseEmulator.getHTTPStatusCode(SUT), SC_OK);
        assertEquals(webTestBaseEmulator.getSUTTitle(), SUT_TITLE);
    }
}