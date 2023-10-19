package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day21_DataProvider1 {

    /*
What is data provider?
****Data provider is used to get list of data
****We can get data from external files, such as excel or json files
****DataProvider is an annotation of testNG
****I use Data Provider to get data such as credentials from excel sheet
------------------------------------------------------------------------
How to you get data in you TestNG framework?
****In Data provider method, I use @DataProvider annotation, in Test method I give the method name in the parameter
------------------------------------------------------------------------
Data Provider has 2 parameters:
****1. name : Used to give custom name for Data Provider.   @DataProvider(name = "my_smoke_data")
****2. parallel : Used to do parallel testing. Default is parallel = false. We can make parallel = true

 -Data provider merhodu olusturduk: 2D Array olusturup dataları icine koyuyoruz.
 -anatationu kullanıyoruz: @DataProvider(name = "my_smoke_data",parallel = true)
 -testimizi dataProvider ile iliskilendiriyoruz:@Test(dataProvider = "my_smoke_data") //parantez icine DataProvider methodunun ismini koyuyoruz
 */

    //    DATA PROVIDER METHOD
      @DataProvider(name = "my_smoke_data",parallel = true)
    public Object[][] customerData(){ //methot olusturduk
//    TEST DATA
        Object [][] customerCredentials = {  // Object yerine String de koyabiliriz. Object parent oldugu icin kullanabiliriz
                {"sam.walker@bluerentalcars.com","c!fas_art"}, //bu verileri girmek icin DataProvider "for" kullanmaya gerek duymaz.
                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
        return customerCredentials;
    }
 //    TEST METHOD 1
    @Test(dataProvider = "my_smoke_data") //parantez icine DataProvider methodunun ismini koyuyoruz:"customerData" (@Test(dataProvider = "customerData")). Fakat @DataProvider'a parantez acıp isim verirsek o ismi kullanmalıyız parantez icine ,yoksa consolda error olur.
    public void dataProviderTest1(String email,String password){
        System.out.println("USERNAME : "+email+" | PASSWORD : "+password); //hepsini bu sekilde consola yazdırdı:USERNAME : sam.walker@bluerentalcars.com | PASSWORD : c!fas_art

    }

    //   TEST METHOD 2
    @Test(dataProvider = "my_smoke_data")
    public void dataProviderTest2(String user,String pass){
        System.out.println(user+" | "+pass);  //hepsini bu sekilde consola yazdırdı:sam.walker@bluerentalcars.com | c!fas_art
    }



}
