package base;

import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.DriverSetup;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class WebTestBase extends DriverSetup {

    public WebTestBase() throws IOException {
        super();
    }

    public void openSUT(String sut) throws Exception {
        driver().get(sut);
    }

    public int getHTTPStatusCode(String sut) throws IOException {
        final URL url = new URL(sut);
        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        return conn.getResponseCode();
    }

    public String getSUTTitle() throws Exception {
        return driver().getTitle();
    }

    public void driverWaitUntil(String sut){
        driverWait().until(ExpectedConditions.urlToBe(sut+"/"));
    }

}
