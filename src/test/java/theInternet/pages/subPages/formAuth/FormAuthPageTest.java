package theInternet.pages.subPages.formAuth;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import theInternet.base.Base;

public class FormAuthPageTest extends Base {
    public FormAuthPage formAuthPage;
    public SecureAreaPage secureAreaPage;

    private SoftAssert softAssert = new SoftAssert();

    private void openFormAuthPage(){
        formAuthPage = homePage.openFormAuthPage();
    }

    @Test
    public void testValidUsernameValidPassword() {
        openFormAuthPage();
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
    public void testValidUsernameInvalidPassword(){
        openFormAuthPage();
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
    public void testInvalidUsernameValidPassword(){
        openFormAuthPage();
        String username = "invalid username", password = "SuperSecretPassword!";
        formAuthPage.sendTextToUsernameInput(username);
        formAuthPage.sendTextToPasswordInput(password);
        formAuthPage.clickOnLoginButton();
        softAssert.assertTrue(formAuthPage.isLoginFailedMsgDisplayed());
        String expectedInvalidUsernameMsg = "Your username is invalid!\n" +
                "×";
        softAssert.assertEquals(formAuthPage.getLoginMsgStatus(),expectedInvalidUsernameMsg);
        softAssert.assertAll();
    }

    @Test
    public void testInvalidUsernameInvalidPassword(){
        openFormAuthPage();
        String username = "invalid username", password = "invalid password";
        formAuthPage.sendTextToUsernameInput(username);
        formAuthPage.sendTextToPasswordInput(password);
        formAuthPage.clickOnLoginButton();
        softAssert.assertTrue(formAuthPage.isLoginFailedMsgDisplayed());
        String expectedInvalidUsernameMsg = "Your username is invalid!\n" +
                "×";
        softAssert.assertEquals(formAuthPage.getLoginMsgStatus(),expectedInvalidUsernameMsg);
        softAssert.assertAll();
    }

    @Test void testLogout(){
        openFormAuthPage();
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