package theInternet.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import theInternet.base.Base;

public class Utils extends Base {
    /**
     * This method is to setup google chrome driver
     *
     * @return ChromeDriver Object
     */
    public static ChromeDriver openChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /**
     * This method is to setup google chrome driver
     *
     * @return FirefoxDriver Object
     */
    public static FirefoxDriver openFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    /**
     * This method is to get the get the config file path
     */
    public static String getConfigFilePath() {
        return System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
    }

    public static void waitForElementVisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
