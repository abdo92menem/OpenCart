package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    // Method to take screenshot when test case fail
    public static void captureScreenShot(WebDriver driver, String screenshotName) {

        Path dest = Paths.get(System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + ".png");

        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot !!!" + e.getMessage());
            e.printStackTrace();
        }
    }
}
