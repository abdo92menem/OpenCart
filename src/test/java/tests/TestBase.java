package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;
import java.util.HashMap;

public class TestBase {
    public static WebDriver driver;

    public static String downloadsPath = System.getProperty("user.dir") + "\\Downloads";

    public static ChromeOptions setChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();

        chromePrefs.put("download.default_directory", downloadsPath);
        options.setExperimentalOption("prefs", chromePrefs);

        return options;
    }

    public static FirefoxOptions setFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();

        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", downloadsPath);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        options.addPreference("browser.download.manager.showWhenStarting", false);

        return options;
    }

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
                driver = new ChromeDriver(setChromeOptions());
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
                driver = new FirefoxDriver(setFirefoxOptions());
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.navigate().to("http://localhost/opencart/");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    // take screenshot when test case fail and add it to in the Screenshots folder
    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot...");
            Helper.captureScreenShot(driver, result.getName());
        }
    }
}
