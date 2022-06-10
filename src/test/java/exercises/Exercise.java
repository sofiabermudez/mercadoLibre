package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OfertasPage;
import pages.ProductoPage;
import pages.TiendaPage;

//Es el que abro Ofertas desde la barra y voy a la segunda tienda desde la HomePage
public class Exercise {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mercadolibre.com.uy/");
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

    @Test
    public void main () {

        HomePage homePage = new HomePage(driver);

        OfertasPage ofertas = homePage.clickOfertas();

        String precio = ofertas.getPrecioPrimeraOferta();
        String nombre = ofertas.getNombrePrimeraOferta();
        String descuento = ofertas.getDescuentoPrimeraOferta();

        ProductoPage producto = ofertas.clickPrimeraOferta();

        Assert.assertEquals(precio, producto.getMonedaProducto() + ' ' + producto.getPrecioProducto() + producto.getCentavosProducto(), "Los precios no son iguales.");
        Assert.assertEquals(nombre, producto.getNombreProducto(), "Los nombres no son iguales.");
        Assert.assertEquals(descuento, producto.getDescuentoProducto(), "Los porcentajes no son iguales.");

        HomePage homeAgain = producto.clickToHome();
        String nombreTienda = homeAgain.getNombreTienda();

        TiendaPage tienda = homeAgain.clickSegundaTiendas();
        Assert.assertEquals(nombreTienda, tienda.getNombreTienda(), "Los nombres no son iguales.");

    }
}
