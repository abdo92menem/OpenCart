package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    protected WebDriver driver;
    public static JavascriptExecutor jsExecuter;
    public Select select;
    public static Actions action;

    // Constructor
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    protected static void clickButton(WebElement button) {
        button.click();
    }

    protected static void setElementText(WebElement txtElement, String text) {
        txtElement.sendKeys(text);
    }

    protected void scrollToArea(String x, String y) {
        String jsText = "window.scrollBy(" + x + "," + y + ")";
        jsExecuter.executeScript(jsText);
    }

    protected void scrollToBottom() {
        jsExecuter.executeScript("scrollBy(0, 2500)");
    }

    protected void clearText(WebElement element) {
        element.clear();
    }
}
