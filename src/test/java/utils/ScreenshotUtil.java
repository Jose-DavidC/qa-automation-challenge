package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String name) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = "evidencias/" + name + "_" + timestamp + ".png";
        try {
            FileUtils.copyFile(srcFile, new File(filename));
        } catch (IOException e) {
            System.err.println("Error guardando la captura: " + e.getMessage());
        }
    }
}
