package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static utils.ConfigReader.properties;

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

        try {
            element.clear();
        } catch (Exception ignored) {
        }
        element.sendKeys(text);
    }
    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilInvisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
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
    public void clickWithJS(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void selectFromAutocomplete(By inputLocator, String valueToType, By optionLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));
        input.clear();
        input.sendKeys(valueToType);
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator)).click();
    }
    public void waitUntilLoaderDisappears(By loader) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }


    public static String get(String key) {
        return properties.getProperty(key);
    }

    protected void selectByVisibleText(By locator, String visibleText) {
        Select dropdown = new Select(waitForVisibility(locator));
        dropdown.selectByVisibleText(visibleText);
    }
}

