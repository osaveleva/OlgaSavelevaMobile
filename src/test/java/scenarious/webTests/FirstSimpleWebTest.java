package scenarious.webTests;


import base.Hooks;
import base.WebTestBase;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.SUT_TITLE;
import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class FirstSimpleWebTest extends Hooks {
    private WebTestBase webTestBase = new WebTestBase();

    protected FirstSimpleWebTest() throws IOException {
        super();
    }

    @Test(description = "Check website")
    private void websiteTest() throws Exception {
        webTestBase.openSUT(SUT);
        webTestBase.driverWaitUntil(SUT);
        assertEquals(webTestBase.getHTTPStatusCode(SUT), HttpStatus.SC_OK);
        assertEquals(webTestBase.getSUTTitle(), SUT_TITLE);
    }
}