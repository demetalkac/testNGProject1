package techproed.tests.dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;
public class Day21_DataProvider3 {
    /*
    In this method, we will get the data from EXCEL using DATA PROVIDER
    The only difference between class 2 and class 3 is the place where we get teh data
    In class 2, we received the data from the class itself. In this class, we get the data from excel
     */
    BlueRentalHomePage homePage;
    BlueRentalLoginPage loginPage;
    @DataProvider
    public Object[][] customerData(){

//     EXCEL  DATALARI ->  DATA PROVIDER -> TEST METHODLARI

//    TEST DATA. GET DATA FROM EXCEL
//        PATH OF EXCEL SHEET
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
//        SHEET NAME
        String sheetName = "customer_info";
//        CALL EXCEL UTIL CLASS
        ExcelUtils excelUtils=new ExcelUtils(path,sheetName); //excel utiles classından method kullanmak icin obje olusturduk(cunku method static degildi)
//  ExcelUtils excelUtils=new ExcelUtils("./src/test/java/resources/mysmoketestdata.xlsx", "customer_info"); //gunduz dersinde;"String path" ve "String sheetName" birlestirdi,ayrı ayrı string icine koymadan.
//        USE ONE OF THE EXCEL UTIL METHOD TO RECEIVE THE DATA FROM THE EXCEL

        Object [][] customerCredentials = excelUtils.getDataArrayWithoutFirstRow(); //getDataArrayWithoutFirstRow() methodunu kullandık cunku ilk row'a(baslık) ihtiyacımız yok,verileri kullanacagız.
//        Object [][] customerCredentials = {
//                {"sam.walker@bluerentalcars.com","c!fas_art"},
//                {"kate.brown@bluerentalcars.com","tad1$Fas"},
//                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
//                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
//        };
        return customerCredentials;
    }
    //    1. Create a login method
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new BlueRentalHomePage();
        loginPage =new BlueRentalLoginPage();
        ReusableMethods.waitFor(1);
        try {
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
        try{
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }
        ReusableMethods.waitFor(1);
    }
    @Test(dataProvider = "customerData")
    public void customerLoginTest(String username, String password){
//            Takes us to the login page
        login();
        loginPage.emailBox.sendKeys(username);
        ReusableMethods.waitFor(1);
        loginPage.password.sendKeys(password);
        ReusableMethods.waitFor(1);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
//            Verify if login is successful
//            IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
        ReusableMethods.verifyElementDisplayed(homePage.userID);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
