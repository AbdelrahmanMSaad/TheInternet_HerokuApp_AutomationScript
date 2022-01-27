package theInternet.pages.subPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import theInternet.base.Base;

public class AlertsPageTest extends Base {
    public AlertsPage alertsPage;
    private final SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    private void openAlertsPage(){
        alertsPage = homePage.openAlertsPage();
    }

    @Test
    public void testOpeningAnAlertAndAcceptingIt(){
        alertsPage.clickOnClickOnJSAlertButton();
        alertsPage.acceptAlert();
        alertsPage.clickOnClickForJSConfirmButton();
        alertsPage.acceptAlert();
    }

    @Test
    public void testOpeningAnAlertAndDismissingIt(){
        alertsPage.clickOnClickForJSConfirmButton();
        alertsPage.dismissAlert();
    }

    @Test
    public void testSendingKeysToTheAlert(){
        String text = "text to be sent to the alert";
        alertsPage.clickOnClickForJSPromptButton();
        alertsPage.sendTextToAlert(text);
    }
}