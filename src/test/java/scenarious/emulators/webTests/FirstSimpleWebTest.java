package scenarious.emulators.webTests;


import base.Hooks;
import base.WebTestBase;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.*;
import static org.apache.http.HttpStatus.*;
import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class FirstSimpleWebTest extends Hooks {
    private WebTestBase webTestBaseEmulator = new WebTestBase();

    protected FirstSimpleWebTest() throws IOException {
        super();
    }

    @Test(description = "Check website")
    protected void websiteTest() throws Exception {
        webTestBaseEmulator.openSUT(SUT);
        webTestBaseEmulator.driverWaitUntil(SUT);
        assertEquals(webTestBaseEmulator.getSUTTitle(), SUT_TITLE.getRecord());
        assertEquals(webTestBaseEmulator.getHTTPStatusCode(SUT), SC_OK);
        assertEquals(webTestBaseEmulator.getSUTTitle(), SUT_TITLE.getRecord());
    }
}