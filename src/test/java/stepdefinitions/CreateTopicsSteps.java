package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ConfigReader;
import utils.Hooks;
import utils.ScreenshotUtil;

import java.util.List;
import java.util.Map;

public class CreateTopicsSteps {
    private final WebDriver driver;
    private AdminLoginPage adminLoginPage;
    private SectorPage sectorPage;

    public CreateTopicsSteps() {
        this.driver = Hooks.getDriver();
    }

    @Given("que el usuario ha iniciado sesión como administrador")
    public void inicioSesionAdmin() {
        driver.get(ConfigReader.get("admin.url"));

        adminLoginPage = new AdminLoginPage(driver);

        String email = ConfigReader.get("admin.user");
        String password = ConfigReader.get("admin.password");
        adminLoginPage.login(email, password);
        adminLoginPage.clickLoginAdmin();

        ScreenshotUtil.takeScreenshot(driver, "Login-admin");
    }

    @When("crea las siguientes estructuras:")
    public void crearEstructuras(DataTable dataTable) {
        List<Map<String, String>> estructuras = dataTable.asMaps(String.class, String.class);

        SectorPage sectorPage = new SectorPage(driver);
        TemaPage temaPage = new TemaPage(driver);
        // SubtemaPage subtemaPage = new SubtemaPage(driver);
        // PreguntaPage preguntaPage = new PreguntaPage(driver);

        for (Map<String, String> estructura : estructuras) {
            String sector = estructura.get("NombreSector");
            String tema = estructura.get("NombreTema");
            String subtema = estructura.get("NombreSubtema");
            String pregunta = estructura.get("TextoPregunta");
            String tipo = estructura.get("Tipo");

            sectorPage.SelectSector();
            sectorPage.createSector(sector);
            ScreenshotUtil.takeScreenshot(driver, "Sector-" + sector);

            temaPage.SelectTema();
            temaPage.createTema(sector, tema);
            ScreenshotUtil.takeScreenshot(driver, "Tema-" + tema);

            // subtemaPage.SelectSubtema();
            // subtemaPage.createSubtema(subtema, sector, tema);

            // preguntaPage.SelectPregunta();
            // preguntaPage.createPregunta(pregunta, subtema, tipo);
        }
    }


//            // Crear subtema
//            SubtemaPage subtemaPage = new SubtemaPage(driver);
//            subtemaPage.SelectSubtema();
//            subtemaPage.createSubtema(subtema, sector, tema);
//
//            // Crear pregunta
//            PreguntaPage preguntaPage = new PreguntaPage(driver);
//            preguntaPage.SelectPregunta();
//            preguntaPage.createPregunta(pregunta, subtema, tipo);
}









