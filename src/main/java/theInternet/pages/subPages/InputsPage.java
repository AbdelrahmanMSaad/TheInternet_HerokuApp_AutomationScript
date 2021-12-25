package theInternet.pages.subPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import theInternet.base.Base;
import theInternet.utils.Utils;

public class InputsPage extends Base {
    protected WebDriver driver;
    @FindBy(tagName = "input")
    private WebElement numberInput;

    public InputsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This method is to send text to number input
     *
     * @param number
     */
    public void sendTextToNumberInput(String number) {
        Utils.waitForElementVisibility(this.driver, numberInput);
        numberInput.sendKeys(number);
    }

    /**
     * This method is to get the text inside the number input
     *
     * @return String
     */
    public String getTextInsideNumberInput() {
        Utils.waitForElementVisibility(this.driver, numberInput);
        return numberInput.getAttribute("value");
    }

    public void clearNumberInput() {
        Utils.waitForElementVisibility(this.driver, numberInput);
        numberInput.clear();
    }
}
