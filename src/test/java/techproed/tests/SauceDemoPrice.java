package techproed.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.pages.SauceDemoHomePage;
import techproed.pages.SauceDemoProductsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;

import static org.testng.AssertJUnit.assertEquals;

public class SauceDemoPrice {
    /*
  Given
    Go to  https://www.saucedemo.com/
  When
    Enter the username  as "standard_user"
  And
    Enter the password as "secret_sauce"
  And
    Click on login button
  Then
    Assert that total price of all products is 129.94 dollars
  And
    Flash each web element you used
   */
    SauceDemoHomePage saucedemoHomePage;
    SauceDemoProductsPage saucedemoProductsPage;
   @Test
   public  void totalPrice() {
//     Go to  https://www.saucedemo.com/
       Driver.getDriver().get(ConfigReader.getProperty("saurcedemo_url"));

//    Enter the username  as "standard_user"
        saucedemoHomePage = new SauceDemoHomePage();
        saucedemoHomePage.usernameInput.sendKeys(ConfigReader.getProperty("saurcedemo_username"));

//    Enter the password as "secret_sauce"
       saucedemoHomePage.passwordInput.sendKeys(ConfigReader.getProperty("saurcedemo_password"));
//    Click on login button
       saucedemoHomePage.loginButton.click();

//    Assert that total price of all products is 129.94 dollars
       saucedemoProductsPage =new SauceDemoProductsPage();


       double totalPrice = 0;
       for (WebElement w : saucedemoProductsPage.prices) {
//           System.out.println(w.getText().replace("\\$","")); //
           totalPrice += Double.parseDouble(w.getText().replaceAll("\\$", ""));
       }

       assertEquals(129.94, totalPrice);

//    Flash each web element you used
       Driver.closeDriver();


   }

    @Test(groups = "smoke-test")
    public  void totalPrice1() { // bu testte JSUtils classindan  "JSUtils.flash" methodunu kullanık.
//     Go to  https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("saurcedemo_url"));

//    Enter the username  as "standard_user"
        saucedemoHomePage = new SauceDemoHomePage();

        JSUtils.flash(saucedemoHomePage.usernameInput);
        saucedemoHomePage.usernameInput.sendKeys(ConfigReader.getProperty("saucedemo_username"));

//        Enter the password as "secret_sauce"
        JSUtils.flash(saucedemoHomePage.passwordInput);
        saucedemoHomePage.passwordInput.sendKeys(ConfigReader.getProperty("saucedemo_password"));

//        Click on login button
        JSUtils.flash(saucedemoHomePage.loginButton);
        saucedemoHomePage.loginButton.click();

//        Assert that total price of all products is 129.94 dollars

        double totalPrice = 0;
        for (WebElement w : saucedemoProductsPage.prices) {
            JSUtils.flash(w);
            totalPrice += Double.parseDouble(w.getText().replaceAll("\\$", ""));
        }

        assertEquals(129.94, totalPrice);

//        Flash each web element you used
        Driver.closeDriver();
    }


}
