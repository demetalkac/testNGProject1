package techproed.tests.smoketest.logintests;

import com.github.javafaker.Faker;

import org.testng.Assert;
import org.testng.annotations.Test;

import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;
import java.io.IOException;

    /*
       Name:
    US100208_Negative_Login
    Description:
    User should not be able login with incorrect credentials
    Acceptance Criteria:
    As customer, I should not be able to log in the application
    Customer email: fake@bluerentalcars.com
    Customer password: fakepass
    Error: User with email fake@bluerentalcars.com not found
     */

public class Day19_NegativeLoginTest {
    BlueRentalHomePage homePage;
    BlueRentalLoginPage loginPage;
    Faker faker;
    @Test(groups = "minor-regression-group")
    public void US100208_Negative_Login() throws IOException {
//        As customer, I should not be able to log in the application
        //going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        click on home page login link
        homePage = new BlueRentalHomePage();
        loginPage= new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);

        try {
            homePage.userID.click();
            homePage.logoutLink.click();   //try-catch'i "homePage.homePageLoginLink.click();" deki problemi cozmek icin
            homePage.OK.click();
        }catch (Exception E){

        }

        homePage.homePageLoginLink.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
//        Customer email: fake@bluerentalcars.com
//        Customer password: fakepass
        loginPage.emailBox.sendKeys("fake@bluerentalcars.com");
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys("fakepass");
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
//        Error: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email fake@bluerentalcars.com not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");
    }
    @Test  //yukardaki ile aynı ,farkı bu testte "faker class" kullanarak yaptık
    public void invalidCredsTest() throws IOException {
//        As customer, I should not be able to log in the application
        //going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        click on home page login link
        homePage = new BlueRentalHomePage();
        loginPage= new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
//        Customer email: fake@bluerentalcars.com
//        Customer password: fakepass
        faker=new Faker();
        String fakeEmail = faker.internet().emailAddress();
        loginPage.emailBox.sendKeys(fakeEmail);
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys(faker.internet().password(4,6));//fake pass 4-6 digit
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
//        Error: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email "+fakeEmail+" not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");
        Driver.closeDriver();
    }


    @Test
    public void emailError(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new BlueRentalHomePage();
        loginPage = new BlueRentalLoginPage();

        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();

        faker= new Faker();
        String email = faker.internet().emailAddress();
        loginPage.emailBox.sendKeys(email);
        loginPage.password.sendKeys(faker.internet().password(4,6));
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
        //alternatively assert
        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        System.out.println(errorMessage);
        Assert.assertTrue(errorMessage.contains("not found"));
        Assert.assertEquals("User with email " + email + " not found" , errorMessage);
        Assert.assertTrue(loginPage.errorMessage_incorrectEmailPass.isDisplayed());
    }


    @Test
    public void passwordError(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new BlueRentalHomePage();
        loginPage = new BlueRentalLoginPage();

        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();


        faker= new Faker();
        loginPage.emailBox.sendKeys("jack@gmail.com");
        loginPage.password.sendKeys(faker.internet().password(4,6));
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
        //alternatively assert
        String errorMessage = loginPage.errorMessage_incorrectEmailPass.getText();
        System.out.println(errorMessage);
        Assert.assertTrue(loginPage.errorMessage_incorrectEmailPass.isDisplayed());
        Assert.assertEquals("Bad credentials" , errorMessage);

    }
}
