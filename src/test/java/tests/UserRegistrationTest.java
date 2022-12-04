package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.time.Duration;

public class UserRegistrationTest extends TestBase {
    HomePage home;
    RegisterPage registerPage;

    @Test(priority = 0, alwaysRun = true)
    public void registerWithMandatory() throws InterruptedException {
        home = new HomePage(driver);
        home.openRegistrationPage();

        Faker fakeData = new Faker();
        String firstName = fakeData.name().firstName();
        System.out.println(firstName);
        String lastName = fakeData.name().lastName();
        System.out.println(lastName);
        String email = fakeData.internet().emailAddress();
        System.out.println(email);
        String password = fakeData.number().digits(8).toString();
        System.out.println(password);

        registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(firstName, lastName, email, password, false, true);

        Thread.sleep(1000);

        Assert.assertEquals("Your Account Has Been Created!", registerPage.AccountCreatedMsg.getText());
    }
}
