package techproed.tests.dataprovider;

import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class DataProviderTestA {
// ===================TURKCE
    /*
    1)Data Provider; bir cok veriyi Test Caselere loop kullanmadan aktarmak icin kullanılır.
    2)Data Provider 2D array object return eder.
    3)Data Provider testNG'den gelir
    4)Data Provider DDT(Data Driven Testing)icin kullanılır.Birden fazla senaryoyu test caselerde test edebilmek,kullanabilmek icin kullanılır.
    5)DataProvider teste nasıl iliskilendirilir?
    Data Provider da 2 parametre vardır:name, parallel
    - "name" kullanarak yapabiliriz:
    @DataProvider annotation ile veri havuzu olusturulur.
     @Test methodlarına bu data havuzu baglanır(@Test(dataProvider = "data provider objesinin ismi")

     @DataProvider                                   @Test(dataProvider = "urunler")
    public Object[][] urunler(){                     public void googleAramasi(String cars){
        Object urunListesi[][] = {     ===>>>        Driver.getDriver().get("https://www.google.com");
                {"tesla"},.....                      .....

                              VEYA
   - "parallel" kullanarak yapabiliriz:

    @DataProvider(name = "smoke_test_data")           @Test(dataProvider = "(name = "smoke_test_data")")
    public Object[][] urunler(){                     public void googleAramasi(String cars){
        Object urunListesi[][] = {     ===>>>        Driver.getDriver().get("https://www.google.com");
                {"tesla"},.....                      .....

     */
//     Data Provider Methodu

   @DataProvider(name = "smoke_test_data")
    public Object[][] urunler(){
        Object urunListesi[][] = {
                {"tesla"}, //her arrayin icinde bir tane oldugu icin asagıda @test metoduna bir tane String koymalıyız.
                {"bwm"},    //yani {"tesla"}'nın yanında baska bir veri yok({"tesla","toros"} seklinde degil)
                {"mercedes"},
                {"honda"},
                {"toyota"}
        };
        return urunListesi;
    }

//  TEST METHODU
    @Test(dataProvider = "urunler") //bununla test methodunu dataProvider methoduna bagladık ve dataları aldık
    public  void aramaTesti(String data){
        System.out.println(data);

    }

    /*
    1-Google a git
    2-Pop up cıkarsa kabul et
    3-cars'ları arama kutusuna gir ve enter'a bas
    4-Sayfa title'nin aradıgın kelimeyi icerdigini assert et
    5-Driver'i kapat
     */

//    GOOGLE ARAMASI
   @Test(dataProvider = "smoke_test_data")
   public void googleAramasi(String cars){
       Driver.getDriver().get("https://www.google.com");
       try {
           Driver.getDriver().findElement(By.id("L2AGLb")).sendKeys(cars+ Keys.ENTER);
       }catch (Exception e){

       }
//       Driver.getDriver().findElement(By.id("L2AGLb")).sendKeys(cars+ Keys.ENTER);
       Driver.getDriver().findElement(By.name("q")).sendKeys(cars+ Keys.ENTER);
       Assert.assertTrue(Driver.getDriver().getTitle().contains(cars));
       Driver.closeDriver();

   }


    }
