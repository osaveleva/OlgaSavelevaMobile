package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverSetup;

import java.io.IOException;

import static constants.MobileTestingConstants.PASSWORD;

/**
 * PageObject for ContactManager application
 */

public class ContactManagerPage extends DriverSetup {
    public ContactManagerPage() throws IOException {
        super();
    }

    @FindBy(id = "in.smartappcart.contactmanager:id/ll2")
    public WebElement contactUs;

    @FindBy(id = "in.smartappcart.contactmanager:id/textcrname")
    public WebElement contactName;

    @FindBy(id = "in.smartappcart.contactmanager:id/textcrcontact")
    public WebElement contactNaumber;

    @FindBy(id = "in.smartappcart.contactmanager:id/textcremail")
    public WebElement contactEmail;

    @FindBy(id = "in.smartappcart.contactmanager:id/crsubmit2")
    public WebElement contactUsSubmitButton;

    @FindBy(id = "in.smartappcart.contactmanager:id/crreset2")
    public WebElement resetPassword;

    @FindBy(id = "in.smartappcart.contactmanager:id/ll1")
    public WebElement setPassword;

    @FindBy(id = "in.smartappcart.contactmanager:id/texttitle1")
    public WebElement resetTitle1;

    @FindBy(id = "in.smartappcart.contactmanager:id/texttitle2")
    public WebElement resetTiltle2;

    @FindBy(id = "in.smartappcart.contactmanager:id/crpass")
    private WebElement crpass;

    @FindBy(id = "in.smartappcart.contactmanager:id/crsubmit")
    private WebElement submitPasswordButton;


    public void submitPassword() {
        crpass.sendKeys(PASSWORD.getRecord());
        submitPasswordButton.click();
    }

    public String titleValue(WebElement element) {
        return element.getText();
    }
}
