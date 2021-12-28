package theInternet.pages.subPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import theInternet.base.Base;

public class CheckboxesPageTest extends Base {
    private final SoftAssert softAssert = new SoftAssert();
    public CheckboxesPage checkboxesPage;

    @BeforeMethod
    private void openCheckboxesPage() {
        checkboxesPage = homePage.openCheckboxesPage();
    }

    @Test
    public void testCheckingTheFirstCheckbox() {
        checkboxesPage.clickOnFirstCheckBox();
        softAssert.assertTrue(checkboxesPage.isFirstCheckboxChecked());
        softAssert.assertAll();
    }

    @Test
    public void testCheckingTheSecondCheckbox() {
        checkboxesPage.clickOnSecondCheckBox();
        softAssert.assertFalse(checkboxesPage.isSecondCheckboxChecked());
        softAssert.assertAll();
    }
}