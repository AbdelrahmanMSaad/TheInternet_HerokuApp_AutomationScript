package theInternet.pages.subPages.formAuth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import theInternet.base.Base;

public class FormAuthPage extends Base {
    protected WebDriver driver;

    private WebDriverWait wait;

    public FormAuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//i[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement loginFailedMsg;
    
    /**
     * send text to username input
     *
     * @param username
     */
    public void sendTextToUsernameInput(String username) {
        waitForElementVisibility(usernameInput);
        usernameInput.sendKeys(username);
    }

    /**
     * This method is to send text to the password input
     *
     * @param password
     */
    public void sendTextToPasswordInput(String password) {
        waitForElementVisibility(passwordInput);
        passwordInput.sendKeys(password);
    }

    /**
     * This method is to click on login button
     *
     * @return SecureAreaPage object
     */
    public SecureAreaPage clickOnLoginButton() {
        waitForElementToBeClickable(loginButton);
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
            waitForElementVisibility(loginFailedMsg);
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
            waitForElementVisibility(loginFailedMsg);
            return loginFailedMsg.getText();
        } catch (Exception e) {
            return null;
        }
    }

    private void waitForElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
