package scenarious.mobilecloud.webTests;


import base.Hooks;
import pageObjects.WebPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.EXPECTED_TITLE;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

@Test(groups = {"web"})
public class CloudWebTest extends Hooks {
    private WebPage webPage = new WebPage();

    protected CloudWebTest() throws IOException {
        super();
    }

    @Test(description = "Check website")
    protected void websiteTest() throws Exception {
        webPage.openSUT(SUT);
        webPage.driverWaitUntil(SUT);
        assertEquals(webPage.getSUTTitle(), EXPECTED_TITLE.getRecord());
        assertEquals(webPage.getHTTPStatusCode(SUT), SC_OK);
    }
}