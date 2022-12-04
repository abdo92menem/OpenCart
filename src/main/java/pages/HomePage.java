package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
        jsExecuter = (JavascriptExecutor)  driver;
        action = new Actions(driver);
    }

    @FindBy(xpath = "//*[@id='top']/div/div[2]/ul/li[2]/div/a")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    public void openRegistrationPage() {
        clickButton(myAccountDropdown);
        clickButton(registerLink);
    }

    public void openLoginPage() {
        clickButton(myAccountDropdown);
        clickButton(loginLink);
    }
}
