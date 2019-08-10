package scenarious.mobileTests.webTests;


import base.Hooks;
import pageObjects.WebPage;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static constants.MobileTestingConstants.*;
import static org.testng.Assert.assertEquals;

@Test(groups = {"web"})
public class WebTest extends Hooks {
    private WebPage webPage = new WebPage();

    protected WebTest() {
        super();
    }

    @Test(description = "Check website")
    private void websiteTest() throws Exception {
        webPage.openSUT(SUT);
        webPage.driverWaitUntil(SUT);
        assertEquals(webPage.getSUTTitle(), EXPECTED_TITLE.getRecord());
        assertEquals(webPage.getHTTPStatusCode(SUT), HttpStatus.SC_OK);
    }

}