package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistroPage extends BasePage {

    private By nombreField = By.id("TxtNombre");
    private By nitField = By.id("TxtNit_I");
    private By sectorInput = By.id("LstSector_I");
    private By sectorOptionCaficultor = By.xpath("//td[contains(text(), 'Caficultor')]");

    public RegistroPage(WebDriver driver) {
        super(driver);
    }
    public void enterName(String name) {
        type(nombreField, name);
    }

    public void enterNit(String nit) {
        type(nitField, nit);
    }
}
