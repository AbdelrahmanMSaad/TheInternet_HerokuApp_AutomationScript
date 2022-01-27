package theInternet.pages.subPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import theInternet.base.Base;
import theInternet.utils.Utils;

public class AlertsPage extends Base {
    protected WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
    private WebElement clickOnJSAlertButton;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
    private WebElement clickForJSConfirmButton;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
    private WebElement clickForJSPromptButton;

    /**
     * This method is to click on the click on JS Alert button
     */
    public void clickOnClickOnJSAlertButton() {
        Utils.waitForElementToBeClickable(this.driver, clickOnJSAlertButton);
        clickOnJSAlertButton.click();
    }

    /**
     * This method is to click on click for confirm button
     */
    public void clickOnClickForJSConfirmButton() {
        Utils.waitForElementToBeClickable(this.driver,clickForJSConfirmButton);
        clickForJSConfirmButton.click();
    }

    /**
     * This method is to click on click for js prompt button
     */
    public void clickOnClickForJSPromptButton() {
        Utils.waitForElementToBeClickable(this.driver,clickForJSPromptButton);
        clickForJSPromptButton.click();
    }

    /**
     * This method is to accept the current alert
     */
    public void acceptAlert() {
        this.driver.switchTo().alert().accept();
    }

    /**
     * This method is to dismiss the current alert
     */
    public void dismissAlert() {
        this.driver.switchTo().alert().dismiss();
    }

    /**
     * This method is to send text to the alert
     *
     * @param text String to be sent to the alert
     */
    public void sendTextToAlert(String text) {
        this.driver.switchTo().alert().sendKeys(text);
    }
}


