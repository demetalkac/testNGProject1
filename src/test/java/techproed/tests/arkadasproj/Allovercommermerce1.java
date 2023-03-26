package techproed.tests.arkadasproj;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import techproed.pages.AlloverCommerceAddressesPage;
import techproed.pages.AlloverCommerceHomePage;
import techproed.pages.AlloverCommerceMyAccountPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static techproed.utilities.ReusableMethods.waitFor;

public class Allovercommermerce1 {
    /*
    User should go to https://www.allovercommerce.com/
    User story ID :US_003
    Test Cace ID : TC 001
    Test Objective : "User should add Billing Address.
                     (My Account > Adressses > Billing Address)"
     Pre-Condition :
     No :1:User should enter First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code and Phone Number.
         2:The registered email address should be filled in automatically.
         3:After clicking 'Save Address', the Billing Address should be added.
     Test Data:
     Expected Result:
     Actual Result:
     Status:

     */
   AlloverCommerceMyAccountPage myAccountPage;
   AlloverCommerceHomePage homePage;
   Faker faker = new Faker();
   @Test
    public void registerSignUp(){
       homePage = new AlloverCommerceHomePage();
       Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
       homePage.register.click();
       homePage.usernameSignUpRegister.sendKeys(faker.name().username());
       homePage.emailSignUpRegister.sendKeys(faker.internet().emailAddress());
       homePage.passwordSignUpRegister.sendKeys(faker.internet().password());
       homePage.agreeBoxSignUpRegister.click();
       homePage.signUpButtonRegister.click();
   }
   @Test
   public void myAccountSignInTest(){
      Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_myaccount_url"));
      myAccountPage = new AlloverCommerceMyAccountPage();
      faker = new Faker();
      waitFor(3);
      myAccountPage.usernameMyAccountSignIn.sendKeys(faker.name().username());
      waitFor(3);
      myAccountPage.passwordMyAccountSignIn.sendKeys(faker.internet().password());
      myAccountPage.signInButtonMyAccountSignIn.click();
   }
}
