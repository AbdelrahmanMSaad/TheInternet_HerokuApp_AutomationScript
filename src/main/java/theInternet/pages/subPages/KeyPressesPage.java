package theInternet.pages.subPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import theInternet.base.Base;
import theInternet.utils.Utils;

public class KeyPressesPage extends Base {
    protected WebDriver driver;

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "target")
    private WebElement keyPressesInput;

    @FindBy(id = "result")
    private WebElement resultText;

    /**
     * This method is to send text to the input
     *
     * @param text to be sent to the input
     */
    public void sendKeysToKeyPressesInput(String text) {
        Utils.waitForElementVisibility(this.driver, keyPressesInput);
        keyPressesInput.sendKeys(text);
    }

    /**
     * This method is to get the basic text that already exists in the result
     * @return  String
     */
    public String getTheBasicResultText(){
        try {
            Utils.waitForElementVisibility(this.driver, resultText);
            return "You entered: ";
        }catch (NoSuchElementException e){
            return null;
        }
    }

    /**
     * This method is to get text from the result
     *
     * @return String
     */
    public String getTextFromTheResult() {
        try{
            Utils.waitForElementVisibility(this.driver, resultText);
            return resultText.getText();
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
