package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

}
