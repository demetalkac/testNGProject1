package techproed.tests.homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestHomePage;
import techproed.pages.TestLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class LoginHomework {
//    https://testcenter.techproeducation.com/index.php?page=form-authentication
//    Login the application using page object model
    @Test
    public void loginTest(){
        Driver.getDriver().get(ConfigReader.getProperty("test_login_url"));
        TestLoginPage testLoginPage =new TestLoginPage();
        TestHomePage testHomePage = new TestHomePage();
        testLoginPage.username.sendKeys("techproed");
        testLoginPage.pasword.sendKeys("SuperSecretPassword ");
        testLoginPage.submitButton.click();

//        verifying login is successful
//        Assert.assertTrue(testHomePage.loginMessage.isDisplayed()); //bunu da olur,asagıdaki "ReusableMethods" classında olusturulan reusable methodu kullandık
        ReusableMethods.verifyElementDisplayed(testHomePage.loginMessage); //Done with reusable method.Recommended.


    }
}
