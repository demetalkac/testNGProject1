package techproed.tests.listeners;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;
public class ListenersTest3 {  //bu classı Day18_PositiveLoginTest'den kopyaladık, sadece yukledigimiz "testng xml" 'li kullanmak icin
                               //File-->settings -->> plugins -->> Marcet place: type "testng xml"  in the searchbox and install and OK
    BlueRentalHomePage homePage;
    BlueRentalLoginPage loginPage;
    @Test
    public void US100201_Admin_Login(){
//going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        click on home page login link
        homePage = new BlueRentalHomePage();
        loginPage= new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        loginPage.emailBox.sendKeys("jack@gmail.com");
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys("1234567890"); //sending incorect credential(listeners icin)
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
//        Verify login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);
//        ALTERNATIVELY WE CAN ASSERT IF HOME PAGE LOGIN LINK IS NOT DISPLAYED. NOT RECOMMENDED
//        ReusableMethods.verifyElementNotDisplayed(homePage.homePageLoginLink);
        Driver.closeDriver();
    }

}
