package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OfertasPage extends BasePage {

    public OfertasPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li [@class = 'promotion-item']")
    private WebElement primeraOferta;

    @FindBy(xpath = "//span [@class = 'promotion-item__price']")
    private WebElement precioPrimeraOferta;

    @FindBy(xpath = "//p [@class = 'promotion-item__title']")
    private WebElement nombrePrimeraOferta;

    @FindBy(xpath = "//span [@class = 'promotion-item__discount']")
    private WebElement descuentoPrimeraOferta;

    public String getPrecioPrimeraOferta () {
        return this.getWait().until(ExpectedConditions.visibilityOf(precioPrimeraOferta)).getText();
    }

    public String getNombrePrimeraOferta() {
        return this.getWait().until(ExpectedConditions.visibilityOf(nombrePrimeraOferta)).getText();
    }

    public String getDescuentoPrimeraOferta() {
        return this.getWait().until(ExpectedConditions.visibilityOf(descuentoPrimeraOferta)).getText();
    }

    public ProductoPage clickPrimeraOferta() {
        this.getWait().until(ExpectedConditions.elementToBeClickable(primeraOferta)).click();
        return new ProductoPage(this.getDriver());
    }


}
