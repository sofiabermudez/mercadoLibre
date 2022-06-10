package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductoPage extends BasePage {

    public ProductoPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//span[@class = 'price-tag-fraction'])[2]")
    private WebElement precioProducto;

    @FindBy(xpath = "(//span[@class = 'price-tag-symbol'])[2]")
    private WebElement monedaProducto;

    @FindBy(xpath = "(//span[@class = 'price-tag-cents'])")
    private WebElement centavosProducto;

    @FindBy(xpath = "//h1 [@class = 'ui-pdp-title']")
    private WebElement nombreProducto;

    @FindBy(xpath = "//span [@class = 'ui-pdp-price__second-line__label ui-pdp-color--GREEN ui-pdp-size--MEDIUM']")
    private WebElement descuentoProducto;

    @FindBy(xpath = "//a [@class = 'nav-logo']")
    private WebElement logoML;

    public String moneda = monedaProducto.getText();
    public String centavos = centavosProducto.getText();
    public String nombre = nombreProducto.getText();
    public String descuento = descuentoProducto.getText();

    public String getPrecioProducto() {
        return this.getWait().until(ExpectedConditions.visibilityOf(precioProducto)).getText();
    }

    public String getMonedaProducto() {
        return this.getWait().until(ExpectedConditions.visibilityOf(monedaProducto)).getText();
    }

    public String getCentavosProducto() {
        return this.getWait().until(ExpectedConditions.visibilityOf(centavosProducto)).getText();
    }

    public String getNombreProducto() {
        return this.getWait().until(ExpectedConditions.visibilityOf(nombreProducto)).getText();
    }

    public String getDescuentoProducto() {
        return this.getWait().until(ExpectedConditions.visibilityOf(descuentoProducto)).getText();
    }

    public HomePage clickToHome() {
        this.getWait().until(ExpectedConditions.elementToBeClickable(logoML)).click();
        return new HomePage(this.getDriver());
    }

}
