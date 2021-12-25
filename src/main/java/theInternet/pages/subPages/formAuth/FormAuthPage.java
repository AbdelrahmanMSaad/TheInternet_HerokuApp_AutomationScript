package theInternet.pages.subPages.formAuth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import theInternet.base.Base;
import theInternet.utils.Utils;

public class FormAuthPage extends Base {
    protected WebDriver driver;
    @FindBy(name = "username")
    private WebElement usernameInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    private WebElement loginButton;
    @FindBy(id = "flash")
    private WebElement loginFailedMsg;

    public FormAuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * send text to username input
     *
     * @param username
     */
    public void sendTextToUsernameInput(String username) {
        Utils.waitForElementVisibility(this.driver, usernameInput);
        usernameInput.sendKeys(username);
    }

    /**
     * This method is to send text to the password input
     *
     * @param password
     */
    public void sendTextToPasswordInput(String password) {
        Utils.waitForElementVisibility(this.driver, passwordInput);
        passwordInput.sendKeys(password);
    }

    /**
     * This method is to click on login button
     *
     * @return SecureAreaPage object
     */
    public SecureAreaPage clickOnLoginButton() {
        Utils.waitForElementToBeClickable(this.driver, loginButton);
        loginButton.click();
        return new SecureAreaPage(this.driver);
    }

    /**
     * This method is to check if the login failed msg is displayed
     *
     * @return boolean
     */
    public boolean isLoginFailedMsgDisplayed() {
        try {
            Utils.waitForElementVisibility(this.driver, loginFailedMsg);
            return loginFailedMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method is to get the login failed msg
     *
     * @return String
     */
    public String getLoginMsgStatus() {
        try {
            Utils.waitForElementVisibility(this.driver, loginFailedMsg);
            return loginFailedMsg.getText();
        } catch (Exception e) {
            return null;
        }
    }

//    private void waitForElementVisibility(WebElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    private void waitForElementToBeClickable(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
}
