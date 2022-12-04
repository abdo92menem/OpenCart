package pages;

import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Defining Register Page Elements

    // Breadcrumb Links
    @FindBy(css = "i.fas.fa-home")
    private WebElement homePageLink;

    @FindBy(linkText = "Account")
    private WebElement breadCrumbAccountLink;

    @FindBy(linkText = "Register")
    private WebElement breadCrumbRegisterLink;

    // Form Elements
    @FindBy(linkText = "login page")
    private WebElement loginPageLink;

    @FindBy(id = "input-firstname")
    private WebElement fNameTxt;

    @FindBy(id = "input-lastname")
    private WebElement lNameTxt;

    @FindBy(id = "input-email")
    private WebElement emailTxt;

    @FindBy(id = "input-password")
    private WebElement passwordTxt;

    @FindBy(id = "input-newsletter-yes")

    private WebElement yesRadioButton;

    @FindBy(id = "input-newsletter-no")
    private WebElement noRadioButton;

    @FindBy(name = "agree")
    private WebElement agreeCheckBox;

    @FindBy(linkText = "Privacy Policy")
    private WebElement privacyLink;

//    @FindBy(className = "btn.btn-primary")
    @FindBy(xpath = "//*[@id='form-register']/div/div/button")
    private WebElement continueButton;

    // Account created Message
    @FindBy(css = "h1")
    public WebElement AccountCreatedMsg;

    public void registerNewUser(String fName, String lName, String email, String password,
                                boolean subscribe, boolean agree) throws InterruptedException {
        // Fill all String inputs fields
        setElementText(fNameTxt, fName);
        setElementText(lNameTxt, lName);
        setElementText(emailTxt, email);
        setElementText(passwordTxt, password);

        Thread.sleep(3000);

        scrollToArea("0", "300");

        Thread.sleep(1000);

        // Radio button
        if (subscribe) {
            clickButton(yesRadioButton);
        } else {
            clickButton(noRadioButton);
        }

        // Checkbox button
        if (agree) {
            clickButton(agreeCheckBox);
        }

        clickButton(continueButton);
    }
}
