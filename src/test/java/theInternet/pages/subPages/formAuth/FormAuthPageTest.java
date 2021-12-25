package theInternet.pages.subPages.formAuth;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import theInternet.base.Base;

public class FormAuthPageTest extends Base {
    private final SoftAssert softAssert = new SoftAssert();
    public FormAuthPage formAuthPage;
    public SecureAreaPage secureAreaPage;

    @BeforeMethod
    private void openFormAuth() {
        formAuthPage = homePage.openFormAuthPage();
    }

    @Test
    public void testValidUsernameValidPassword() {
        String username = "tomsmith", password = "SuperSecretPassword!";
        formAuthPage.sendTextToUsernameInput(username);
        formAuthPage.sendTextToPasswordInput(password);
        secureAreaPage = formAuthPage.clickOnLoginButton();
        softAssert.assertTrue(secureAreaPage.isLoginSuccessMsgDisplayed());
        String expectedSuccessfulLoginMsg = "You logged into a secure area!\n" +
                "×";
        softAssert.assertEquals(secureAreaPage.getLoginSuccessMsg(), expectedSuccessfulLoginMsg);
        softAssert.assertAll();
    }

    @Test
    public void testValidUsernameInvalidPassword() {
        String username = "tomsmith", password = "invalid password";
        formAuthPage.sendTextToUsernameInput(username);
        formAuthPage.sendTextToPasswordInput(password);
        formAuthPage.clickOnLoginButton();
        softAssert.assertTrue(formAuthPage.isLoginFailedMsgDisplayed());
        String expectedInvalidPasswordMsg = "Your password is invalid!\n" +
                "×";
        softAssert.assertEquals(formAuthPage.getLoginMsgStatus(), expectedInvalidPasswordMsg);
        softAssert.assertAll();
    }

    @Test
    public void testInvalidUsernameValidPassword() {
        String username = "invalid username", password = "SuperSecretPassword!";
        formAuthPage.sendTextToUsernameInput(username);
        formAuthPage.sendTextToPasswordInput(password);
        formAuthPage.clickOnLoginButton();
        softAssert.assertTrue(formAuthPage.isLoginFailedMsgDisplayed());
        String expectedInvalidUsernameMsg = "Your username is invalid!\n" +
                "×";
        softAssert.assertEquals(formAuthPage.getLoginMsgStatus(), expectedInvalidUsernameMsg);
        softAssert.assertAll();
    }

    @Test
    public void testInvalidUsernameInvalidPassword() {
        String username = "invalid username", password = "invalid password";
        formAuthPage.sendTextToUsernameInput(username);
        formAuthPage.sendTextToPasswordInput(password);
        formAuthPage.clickOnLoginButton();
        softAssert.assertTrue(formAuthPage.isLoginFailedMsgDisplayed());
        String expectedInvalidUsernameMsg = "Your username is invalid!\n" +
                "×";
        softAssert.assertEquals(formAuthPage.getLoginMsgStatus(), expectedInvalidUsernameMsg);
        softAssert.assertAll();
    }

    @Test
    void testLogout() {
        String username = "tomsmith", password = "SuperSecretPassword!";
        formAuthPage.sendTextToUsernameInput(username);
        formAuthPage.sendTextToPasswordInput(password);
        secureAreaPage = formAuthPage.clickOnLoginButton();
        softAssert.assertTrue(secureAreaPage.isLoginSuccessMsgDisplayed());
        formAuthPage = secureAreaPage.clickOnLogoutButton();
        String expectedSuccessfulLogout = "You logged out of the secure area!\n" +
                "×";
        softAssert.assertEquals(formAuthPage.getLoginMsgStatus(), expectedSuccessfulLogout);
        softAssert.assertAll();
    }
}