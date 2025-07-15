package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TemaPage extends BasePage {

    private By menuTema = By.xpath("//span[normalize-space()='Tema']");
    private By btnNuevoTema = By.id("ContentPlaceHolder_GridTema_DXCBtn0");
    private By selectsector = By.id("ContentPlaceHolder_GridTema_DXEditor1_I");
    private String opcionSectorXpath = "//div[contains(@id,'LBI') and contains(text(),'%s')]";
    private By inputNombreTema = By.id("ContentPlaceHolder_GridTema_DXEditor2_I");
    private By btnGuardar = By.id("ContentPlaceHolder_GridTema_DXCBtn1");

    public TemaPage(WebDriver driver) {
        super(driver);
    }

    public void SelectTema() {
        click(menuTema);
    }

    public void createTema(String sector, String nombreTema) {
        click(btnNuevoTema);
        type(selectsector, sector);
        By opcionSector = By.xpath(String.format(opcionSectorXpath, sector));
        waitUntilVisible(opcionSector);
        click(opcionSector);
        type(inputNombreTema, nombreTema);
        click(btnGuardar);
        waitUntilInvisible(By.id("ContentPlaceHolder_GridTema_LD"));
    }


}
