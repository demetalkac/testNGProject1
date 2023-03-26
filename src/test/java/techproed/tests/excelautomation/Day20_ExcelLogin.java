package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;
import java.util.List;
import java.util.Map;
public class Day20_ExcelLogin {
    BlueRentalHomePage homePage;
    BlueRentalLoginPage loginPage;
    ExcelUtils excelUtils;  // "ExcelUtils" classından constructor cagırmak icin olusturduk.
    //    will store excel data
    List<Map<String,String>> allTestData;  // Excelden gelen dataları bir degisken icinde tutmak icin List olusturduk.

    //    1. Create a login method--Bu method login sayfasına gitmek icin kullanılacak
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage = new BlueRentalHomePage();
        loginPage =new BlueRentalLoginPage();
        ReusableMethods.waitFor(1);
        //note "NoSuchElementException" aldıgımız icin try-catch kullanıyoruz.
        // SADECE İLK GIRIS ICIN KULLANILACAK BU try-catch:Cunku "homePageLoginLink" butonu sadece ilk giriste sayfada görünür
        // ikinci ve ucuncu grislerde sayfada gorunmedigi icin "NoSuchElementException" alırız.Bu exceptionu handle ediyoruz,test case'imiz calısmaya devam edebilmesi icin.
        try {
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception ignored){
        }
        // SONRAKİ GRİSLER ICIN
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
    @Test
    public void customerLoginTest(){
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
//  DATALARI EXCEL UTILS METHODLARINI KULLANARAK BURAYA ALACAGIZ
        excelUtils=new ExcelUtils(path,sheetName); //ExcelUtils classındaki ilk method. Bu method excele gidecek icindekileri(sheetin icndekileri okuyacak)
//        getDataList() method returns all excel data --excel datalarını getDataList() methodu ile cekelim
//        we stored that data in allTestData variable
        allTestData=excelUtils.getDataList();
//        System.out.println(allTestData); //List<Map<String -->list icinde, ayrı ayrı map'ler var ve bu mapler string(key,value seklinde):[{password=c!fas_art, username=sam.walker@bluerentalcars.com}, {password=tad1$Fas, username=kate.brown@bluerentalcars.com},
//        System.out.println(excelUtils.getColumnsNames()); //[username, password]
//        System.out.println(excelUtils.getCellData(2,1));  //tas1$Fas
//        USING LOOP GET THE VALUES FROM THE MAP AND SEND IN THE UI
        for (Map<String,String> eachData :allTestData){
//            Takes us to the login page
            login();
            loginPage.emailBox.sendKeys(eachData.get("username")); // get() ile map'deki dataları alacagız

            loginPage.password.sendKeys(eachData.get("password"));

            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
//            Verify if login is successful
//            IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
            ReusableMethods.verifyElementDisplayed(homePage.userID);
        }
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
/*     LOGIN FLOW
        click on login LINK          ------>>>>>>  homePage.homePageLoginLink.click(); --->> TRY WHEN LINK IS THERE---> 1st TRY CATCH--> logIn
        send username
        send password                 ----->>>>> DONE
        click on login BUTTON
        I AM ON HOME PAGE
        **********PATTERN 1**********
        click on user id
        click on log out             ----->>>>>>2nd TRY CATCH -> logIn
        click on ok
        I AM ON HOME PAGE AGAIN
        click on login LINK
        *********PATTERN 2***********
        send username
        send password           ----->>>>>>>>>>>>>>>>>@Test Method is used to send credentials and verification
        click on login Button
        I AM ON HOME PAGE AGAIN
        *****************
         click on user id
        click on log out
        click on ok                     ----->>>>>>2nd TRY CATCH -> logIn
        I AM ON HOME PAGE AGAIN
        click on login LINK
         ********************
        send username
        send password       ----->>>>>>>>>>>>>>>>>@Test Method is used to send credentials and verification
        click on login Button
        I AM ON HOME PAGE AGAIN
 */

/*
   Sayfayı manual kontrol etmek icin kullandık:

    raj.khan@bluerentalcars.com - v7Hg_va^
    sam.walker@bluerentalcars.com - c!fas_art
    kate.brown@bluerentalcars.com - tad1$Fas
    pam.raymond@bluerentalcars.com - Nga^g6!

 */