package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='nav-menu-item-link']")
    private WebElement ofertas;

    @FindBy(xpath = "//a [@id = 'view-more']")
    private WebElement verTiendas;

    @FindBy(xpath = "(//div [@class = 'ui-card official-stores-slide is-link'])[2]")
    private WebElement segundaTienda;

    @FindBy(xpath = "(//div [@class='official-stores-slide-title'])[2]")
    private WebElement nombreSegundaTienda;

    public void setOfertas (WebElement ofertas) {
        this.ofertas = ofertas;
    }

    public WebElement getOfertas() {
        return this.ofertas;
    }

    public String getNombreTienda() {
        return this.getWait().until(ExpectedConditions.visibilityOf(nombreSegundaTienda)).getText();
    }

    public OfertasPage clickOfertas() {
        this.getWait().until(ExpectedConditions.elementToBeClickable(ofertas)).click();
        return new OfertasPage(this.getDriver());
    }

    public void clickVerTiendas() {
        this.getWait().until(ExpectedConditions.elementToBeClickable(verTiendas)).click();
        //return new OfertasPage(this.getDriver());
    }

    public TiendaPage clickSegundaTiendas() {
        this.getWait().until(ExpectedConditions.elementToBeClickable(segundaTienda)).click();
        return new TiendaPage(this.getDriver());
    }
}
