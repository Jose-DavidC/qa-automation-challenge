package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegistroPage;
import utils.ConfigReader;
import utils.Hooks;

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

    @When("intenta iniciar sesión con un usuario inexistente")
    public void intenta_iniciar_sesión_con_un_usuario_inexistente() {
        loginPage.enterCredentials("usuario@invalido.com", "claveIncorrecta");
        loginPage.clickLogin();
    }

    @Then("se debe mostrar un mensaje de error por credenciales inválidas y hacer clic en Registrarse")
    public void validar_mensaje_y_hacer_click_en_registrarse() {
        String mensaje = loginPage.getErrorMessage();
        Assert.assertEquals("Datos incorrectos, porfavor intentelo nuevamente", mensaje);
        loginPage.clickRegister();
        registroPage = new RegistroPage(driver);
    }


    @And("completa el registro con sector {string}")
    public void completa_el_registro_con_sector(String sector) {
        registroPage.enterName("Mi Empresa");
        registroPage.enterNit("123456789");

    }
}
