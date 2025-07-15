package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage extends BasePage {

    private By emailField = By.id("TxtUsuario_I");
    private By passwordField = By.id("TxtClave_I");
    private By loginButton = By.id("BtnIngresar_CD");

    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterCredentials(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
    }

    public void clickLoginAdmin() {
        click(loginButton);
    }

    public void login(String email, String password) {
        enterCredentials(email, password);
        clickLoginAdmin();
    }
}
