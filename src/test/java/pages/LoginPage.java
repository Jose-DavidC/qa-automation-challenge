package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailField = By.id("TxtUsuario_I");
    private By passwordField = By.id("TxtClave_I");
    private By loginButton = By.id("BtnIngresar");
    private By registerLink = By.linkText("Registrate aquí");
    private By errorMessage = By.id("lblRes");
    private By confrimRegister = By.id("BtnRegistrar");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterCredentials(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void clickRegister() {
        click(registerLink);
    }
     public void clickConfirm(){
        click(confrimRegister);
     }
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isErrorMessageVisible() {
        return isVisible(errorMessage);
    }
}
