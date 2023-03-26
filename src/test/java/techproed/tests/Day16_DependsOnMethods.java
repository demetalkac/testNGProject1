package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_DependsOnMethods {
    @Test
    public void homePage(){
        System.out.println("I am on the home page");
    }

    @Test(dependsOnMethods = "homePage")
    public void searchPage(){
        System.out.println("I am on the search page");
//        Assert.assertTrue(false);
    }
    /*
    dependsOnMethods = "searchPage"  -> connecting checkOutPage to searchPage
    searchPage will execute right before checkOutPage
    If searchPage PASS -> execute checkoutPage
    If searchPage FAIL -> SKIP checkoutPage
     */
    @Test(dependsOnMethods = "searchPage")
    public void checkOutPage(){
        System.out.println("I am on the checkout page");
    }
 /*
- public void checkOutPage()'i public void searchPage()'methoduna bagladık(aralarında baglantı kurduk); @Test(dependsOnMethods = "searchPage")'i kullanarak, yani "dependsOnMethods" kullanarak yaptık
 -public void checkOutPage() bu testi calıstırınca önce digeri calısacak sonra bu test calısacak.Eger digeri calısırsa yani fail olmazsa bu method calısır.
 yani ilk calısan passed sonra bu method calıssır (run), ama ilk calısan method failed olursa bu bu test "ignored" olur
 -Normalde 2 test arasında conection cok kullanılmaz fakat 2 test case birbiriyle cok iliskili ise baglantı kurulabilir.
 - Bunun yerine aynı test case icinde kullanmak,eger üsteki gecemez ise digeri calısmaz.Fakat test caseler cok büyük ise ayrı ayrı olusturup,aralarında baglantı kurulabilir böyle.

  */

}
