package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegistroPage;
import utils.ConfigReader;
import utils.Hooks;
import utils.ScreenshotUtil;

public class LoginSteps {

    private final WebDriver driver;
    private LoginPage loginPage;
    private RegistroPage registroPage;

    public LoginSteps() {
        this.driver = Hooks.getDriver();
    }

    @Given("el usuario abre la página de inicio")
    public void el_usuario_abre_la_página_de_inicio() {
        driver.get(ConfigReader.get("base.url"));
        loginPage = new LoginPage(driver);
    }

    @When("intenta iniciar sesión con usuario {string} y clave {string}")
    public void intenta_login_con_credenciales(String correo, String clave) {
        loginPage.enterCredentials(correo, clave);
        loginPage.clickLogin();
    }

    @Then("se debe mostrar un mensaje de error por credenciales inválidas")
    public void se_muestra_mensaje_error() {
        String mensaje = loginPage.getErrorMessage();
        Assert.assertEquals("Datos incorrectos, porfavor intentelo nuevamente", mensaje);
        ScreenshotUtil.takeScreenshot(driver, "login_invalido");
    }

    @When("hace clic en Registrarse")
    public void hace_clic_en_registrarse() {
        loginPage.clickRegister();
        registroPage = new RegistroPage(driver);
    }

    @And("completa el formulario con los siguientes datos:")
    public void completa_formulario(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMap(String.class, String.class);

        registroPage.enterName(data.get("Nombre"));
        registroPage.enterNit(data.get("NIT"));
        registroPage.selectSector(data.get("Sector"));
        registroPage.enterPhone(data.get("Teléfono"));
        registroPage.enterEmail(data.get("Correo"));
        registroPage.enterPassword(data.get("Clave"));
        registroPage.submitForm();
    }
    @Then("se muestra un mensaje de éxito indicando que el registro fue exitoso")
    public void  confrimar_registro(){
        String msj= registroPage.getConfirmMessage();
        Assert.assertEquals("Bienvenid@, lo invitamos usar sus datos de acceso para acceder a nuestros servicios.", msj);
        ScreenshotUtil.takeScreenshot(driver, "Registro-exitoso");
    }

}
