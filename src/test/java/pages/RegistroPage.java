package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistroPage extends BasePage {

    private By nombreField = By.id("TxtNombre_I");
    private By nitField = By.id("TxtNit_I");
    private By sectorInput = By.id("LstSector_I");
    private By sectorOptionCaficultor = By.xpath("//td[contains(text(), 'Caficultor')]");
    private By telefonoField = By.id("TxtTelefono_I");
    private By correoField = By.id("TxtCorreo_I");
    private By claveField = By.id("TxtClave_I");
    private By registrarButton = By.id("BtnRegistrar_CD");
    private By ConfirmMessage = By.id("lblRes");

    public RegistroPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        type(nombreField, name);
    }

    public void enterNit(String nit) {
        type(nitField, nit);
    }

    public void selectSector(String sector) {
        click(sectorInput);
        By option = By.xpath("//td[contains(text(), '" + sector + "')]");
        click(option);
    }

    public void enterPhone(String phone) {
        type(telefonoField, phone);
    }

    public void enterEmail(String email) {
        type(correoField, email);
    }

    public void enterPassword(String password) {
        type(claveField, password);
    }

    public void submitForm() {
        click(registrarButton);
    }

    public String getConfirmMessage() {
        return getText(ConfirmMessage);
    }

}

