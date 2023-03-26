package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day20_ExcelLogin2 {

// ===================TURKCE
//==========  NOT: BU CLASS "Day20_ExcelLogin" CLASSI ILE AYNI SADECE TRY-CATCH'SİZ HALİ============================
    BlueRentalHomePage homePage;
    BlueRentalLoginPage loginPage;
    ExcelUtils excelUtils;
    List<Map<String,String>> allTestData;

    @Test
    public void customerLoginTest2() throws IOException {
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";

        excelUtils=new ExcelUtils(path,sheetName);
        allTestData=excelUtils.getDataList();
//        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        for (Map<String,String> eachData :allTestData){
            homePage = new BlueRentalHomePage();
            loginPage =new BlueRentalLoginPage();

            Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
            ReusableMethods.waitFor(2);
          homePage.homePageLoginLink.click();
            loginPage.emailBox.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password"));
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
//            Verify if login is successful
            ReusableMethods.verifyElementDisplayed(homePage.userID);
            ReusableMethods.waitFor(1);
            ReusableMethods.getScreenshot("Screenshot");
            homePage.userID.click();
            homePage.logoutLink.click();
            homePage.OK.click();
            ReusableMethods.waitFor(2);


        }
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
