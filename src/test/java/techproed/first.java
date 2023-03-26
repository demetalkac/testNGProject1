package techproed;



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


public class first {
        BlueRentalHomePage homePage;
        BlueRentalLoginPage loginPage;

        ExcelUtils excelUtils;

        List<Map<String,String>> allData;

        public void login(){

            Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
            homePage = new BlueRentalHomePage();
            loginPage = new BlueRentalLoginPage();

            try{
                homePage.homePageLoginLink.click();
            }catch (Exception ignored){

            }

            try{
                homePage.userID.click();
                homePage.logoutLink.click();
                homePage.OK.click();
                homePage.homePageLoginLink.click();
            }catch (Exception ignored){

            }
        }

        @Test
        public void test(){

            String path =  "./src/test/java/resources/mysmoketestdata.xlsx";
            String sheet = "customer_info";

            excelUtils = new ExcelUtils(path, sheet);

            allData = excelUtils.getDataList();

            for (Map<String, String> w : allData){

                login();
                loginPage.emailBox.sendKeys(w.get("username"));
                loginPage.password.sendKeys(w.get("password"));
                loginPage.loginButton.click();

                ReusableMethods.verifyElementDisplayed(homePage.userID);

            }


        }
        @AfterMethod
        public void tearDown(){
            Driver.closeDriver();
        }


}
/*
SORULAR

1 - Neden login icin ayri method olusturduk?

2-Bu methodda try catch neden kullandik?
Çalıştığımız web sitesinde yani excel verilerini yükleyeceğimiz yerde 2 ayrı sayfa mevcut.
İlki homepage önce bu sayfadan “login” e click yapıp diğer sayfaya geçiyoruz.
Burada ikinci sayfamız yani “loginpage” de email adresi, pasaword bilgilerini girip login’i tıklıyoruz ve
 tekrar homepage’e geçiyoruz. Homepage de login yerinde userId’si olduğu için orayı logout yapıp “ok” yapıyoruz.
 Daha sonrada tekrar diğer kullanıcı login olabiliyor ve bilgilerini girebiliyor.
 Try-catch kullanmaz isek NoSuchElementException alıyoruz (loginID olan yerden dolayı).
 Bu exception’u handle etmek için kullanıyoruz try-catch’

3-Login methodundaki mantigi acikla

4-Test methodunda exceli nasil okuduk?
. ilk önce excel dosyamızın pathini aldık aldığımız pathi bir string container içine koyduk.
. excel içindeki sheet dosyasınıda bir string container içine koyduk.
. excelutil objesi oluşturduk. excel dosyası ve sheet verilerini parametre olarak bu objenin içine koyduk.
. excelutil objemiz ile excel içindeki verilere ulaşabilmek için getDataList metodunu kullanarak elde ettiğimiz verileri allData isimil bir containera koyduk.
. Daha sonra alldata içindeki verileri tek tek for each loop kullanarak çağırdık.
. Su sayede her bir veriyi username ve password olarak girdik ve login butonuna tıkladık.
. Reusablemethodumuzla sayfaya verilerimizin girildiğini verify ettik.

5-ExcelUtils classindaki methodlari nasil kullandik?

6-List<Map<String,String>> data tipinde neden bir konteynir olusturduk?
-Oluyacağımız yani bilgilerini kullanacağımız Excel dosyası 2 sütundan olustuğu için bu değerler Map  data tipinde olur.
 Bu dataların data tipide String’dir. Ama bununla sadece bir satırın bilgileriyle işlem yapabiliriz.
 Tüm tablonun bilgileri için yani tüm satırlar için bu Map ‘i List data tipinin içine koymamız gerekmektedir.
Böylece Map data tipli bir List oluşturmuş oluruz.

7-Verileri nasil loopa koyduk ve kullandik acikla
 */