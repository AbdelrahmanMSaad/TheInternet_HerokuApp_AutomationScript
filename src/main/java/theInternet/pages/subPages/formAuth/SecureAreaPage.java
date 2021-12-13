package theInternet.pages.subPages.formAuth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import theInternet.base.Base;
import theInternet.pages.homePage.HomePage;

public class SecureAreaPage extends Base {
    protected WebDriver driver;

    private WebDriverWait wait;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }


    @FindBy(id = "flash")
    private WebElement loginStatusAlert;

    @FindBy(xpath = "//i[contains(text(),'Logout')]")
    private WebElement logoutButton;

    /**
     * This method is to check if the login success msg is displayed
     *
     * @return boolean
     */
    public boolean isLoginSuccessMsgDisplayed() {
        waitForElementVisibility(loginStatusAlert);
        return loginStatusAlert.isDisplayed();
    }

    /**
     * This method is to get text from the login status alert
     * @return  String
     */
    public String getLoginSuccessMsg(){
        waitForElementVisibility(loginStatusAlert);
        return loginStatusAlert.getText();
    }

    /**
     * This method is to click on logout button
     *
     * @return FormAuthPage object
     */
    public FormAuthPage clickOnLogoutButton() {
        waitForElementVisibility(logoutButton);
        logoutButton.click();
        return new FormAuthPage(this.driver);
    }

    private void waitForElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
