package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SectorPage extends BasePage {

    private By menuSector = By.xpath("//span[normalize-space()='Sector']");
    private By btnNuevoSector = By.id("ContentPlaceHolder_GridSector_DXCBtn0_CD");
    private By inputNombreSector = By.id("ContentPlaceHolder_GridSector_DXEditor1_I");
    private By btnGuardar = By.id("ContentPlaceHolder_GridSector_DXCBtn1");

    public SectorPage(WebDriver driver) {
        super(driver);
    }

    public void SelectSector() {
        click(menuSector);

    }
    public void createSector(String nombre) {
        click(btnNuevoSector);
        type(inputNombreSector, nombre);
        click(btnGuardar);

    }


}

