package techproed.tests.smoketest.logintests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day18_PositiveLoginTest {

 /*
 Name: US100201_Admin_Login
 Description:
 User should be able login as admin
 Acceptance Criteria:
 As admin, I should be able to log in the application
 https://www.bluerentalcars.com/
 Admin email: jack@gmail.com
 Admin password: 12345
  */

    BlueRentalHomePage homePage;
    BlueRentalLoginPage loginPage;
    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void US100201_Admin_Login(){
        Reporter.log("Going to the application URL");
//going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        click on home page login link
        homePage = new BlueRentalHomePage();
        loginPage= new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("blue_admin_email"));
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys(ConfigReader.getProperty("blue_admin_password"));
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
//        Verify login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);
//        ALTERNATIVELY WE CAN ASSERT IF HOME PAGE LOGIN LINK IS NOT DISPLAYED. NOT RECOMMENDED
//        ReusableMethods.verifyElementNotDisplayed(homePage.homePageLoginLink);
        Driver.closeDriver();
        Reporter.log("Test is complete...");
    }

}