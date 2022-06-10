package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TiendaPage extends BasePage {

    public TiendaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//span [@itemprop = 'name'])[2]")
    private WebElement nombreTienda;

    public String getNombreTienda() {
        return this.getWait().until(ExpectedConditions.visibilityOf(nombreTienda)).getText();
    }

}
