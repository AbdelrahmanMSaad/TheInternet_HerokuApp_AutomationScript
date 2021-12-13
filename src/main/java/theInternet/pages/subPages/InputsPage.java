package theInternet.pages.subPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import theInternet.base.Base;

public class InputsPage extends Base {
    protected WebDriver driver;

    protected WebDriverWait wait;

    public InputsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(this.driver,10);
    }
}
