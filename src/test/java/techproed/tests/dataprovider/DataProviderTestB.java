package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class DataProviderTestB {

// ===================TURKCE 3.class

          /*
        -String path olustur
        -sheet name'i al: String sheetName
        -excel utiles classından method kullanmak icin obje olusturduk
        -excelden aldıgım dataları bir degiskene at: "Object [][] customerCredentials ="
        -degiskeni de return et: return customerCredentials;
         */

    @DataProvider
    public Object[][] customerData(){

        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);
//    TEST DATA
        Object [][] customerCredentials = excelUtils.getDataArrayWithoutFirstRow();
        return customerCredentials;
    }

    //   4 tane olan customer dataları ile login testi yapalım
    //    1. Create a login method

    BlueRentalHomePage homePage;
    BlueRentalLoginPage loginPage;

    @Test(dataProvider = "customerData")
    public void customerLoginTest(String email, String password) throws IOException {
        homePage = new BlueRentalHomePage();
        loginPage =new BlueRentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        homePage.homePageLoginLink.click();
        loginPage.emailBox.sendKeys(email);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.verifyElementDisplayed(homePage.userID);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Screenshot");

        homePage.userID.click();
        homePage.logoutLink.click();
        homePage.OK.click();
        ReusableMethods.waitFor(1);
        Driver.closeDriver();


    }



}
