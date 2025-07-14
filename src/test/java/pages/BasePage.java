package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private final int TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void type(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        // Verificamos que esté habilitado antes de limpiar/escribir
        if (element.isEnabled() && element.isDisplayed()) {
            try {
                element.clear();  // Aquí fallaba
            } catch (InvalidElementStateException e) {
                System.out.println("⚠️ Warning: Campo no se puede limpiar, se omite clear().");
            }
            element.sendKeys(text);
        } else {
            throw new IllegalStateException("El campo no está habilitado para escribir.");
        }
    }


    protected void click(By locator) {
        waitForVisibility(locator).click();
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    protected boolean isVisible(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void selectFromAutocomplete(By inputLocator, String valueToType, By optionLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));
        input.clear();
        input.sendKeys(valueToType);
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator)).click();
    }


    protected void selectByVisibleText(By locator, String visibleText) {
        Select dropdown = new Select(waitForVisibility(locator));
        dropdown.selectByVisibleText(visibleText);
    }
}

