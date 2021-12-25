package theInternet.pages.subPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import theInternet.base.Base;

public class InputsPageTest extends Base {
    private final SoftAssert softAssert = new SoftAssert();
    public InputsPage inputsPage;

    @BeforeMethod
    private void openInputsPage() {
        inputsPage = homePage.openInputsPage();
    }

    @Test
    public void testSendingNumbersToTheInputElement() {
        String firstValue = "565", secondValue = "9665", thirdValue = "898771";
        inputsPage.sendTextToNumberInput(firstValue);
        softAssert.assertEquals(inputsPage.getTextInsideNumberInput(), firstValue, "First value is not sent");
        inputsPage.clearNumberInput();
        inputsPage.sendTextToNumberInput(secondValue);
        softAssert.assertEquals(inputsPage.getTextInsideNumberInput(), secondValue, "Second value is not sent");
        inputsPage.clearNumberInput();
        inputsPage.sendTextToNumberInput(thirdValue);
        softAssert.assertEquals(inputsPage.getTextInsideNumberInput(), thirdValue, "Third value is not sent");
        softAssert.assertAll();
    }
}