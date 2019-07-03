package scenarious.webTests;


import base.Hooks;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.SUT_TITLE;
import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class FirstSimpleWebTest extends Hooks {
    protected FirstSimpleWebTest() throws IOException {
        super();
    }

    @Test(description = "Check website")
    private void websiteTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT+"/"));
        assertEquals(RestAssured.get(SUT).statusCode(), HttpStatus.SC_OK);
        assertEquals(driver().getTitle(), SUT_TITLE);
    }

}
