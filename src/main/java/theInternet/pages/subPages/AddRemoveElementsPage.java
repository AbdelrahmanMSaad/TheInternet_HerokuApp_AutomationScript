package theInternet.pages.subPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import theInternet.base.Base;
import theInternet.utils.Utils;

import java.util.List;

public class AddRemoveElementsPage extends Base {
    protected WebDriver driver;

    private int deleteBtnsCount;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        deleteBtnsCount = 0;
    }

    @FindBy(xpath = "//button[@onclick='addElement()']")
    private WebElement addElementButton;

    String deleteButtonXpath = "//button[contains(@class,'added-manually')]";

    /**
     * This method is to click on the add element button
     */
    public void addSingleElement() {
        Utils.waitForElementToBeClickable(this.driver, addElementButton);
        addElementButton.click();
        deleteBtnsCount++;
        try {
            Utils.waitForElementToBeClickable(this.driver, driver.findElement(By.xpath("(" + deleteButtonXpath + ")[" + deleteBtnsCount + "]")));
        } catch (NoSuchElementException e) {
            System.out.println("Element is not added");
        }
    }

    /**
     * This method is to add multiple elements
     * @param count number of times
     */
    public void addMultipleElements(int count){
        for (int i = 0 ; i<count;i++){
            this.addSingleElement();
        }
    }

    public void deleteAllDisplayedDeleteBtns() {
        if (deleteBtnsCount > 0) {
            for (int i = deleteBtnsCount; i >= 1; i--) {
                driver.findElement(By.xpath("(" + deleteButtonXpath + ")[" + i + "]")).click();
            }
        } else {
            System.out.println("delete buttons are not displayed");
        }
    }

    public boolean isAnyDeleteElementsDisplayed(){
        if (deleteBtnsCount > 0){
            try {
                return  driver.findElement(By.xpath("(" + deleteButtonXpath + ")[" + deleteBtnsCount + "]")).isDisplayed();
            }catch (NoSuchElementException e){
                System.out.println("No delete elements displayed");
                return false;
            }
        }else {
            return false;
        }
    }

    public int getDeleteElementsCount(){
        try {
            List<WebElement> deleteElementsList = driver.findElements(By.xpath("(" + deleteButtonXpath + ")"));
            return deleteElementsList.size();
        }catch (NoSuchElementException e){
            return 0;
        }
    }
}
