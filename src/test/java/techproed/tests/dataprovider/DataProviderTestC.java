package techproed.tests.dataprovider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class DataProviderTestC {

//     Bu örnekde, data provider methodumuz Util classtan gelecek

/*
     @Test(dataProvider = "musteriVerileri") seklinde olunca dataProvider aynı classta olsaydı görecekti.Ama farklı bir
      clasta oldugu icin görmedi,bunun icin;
      "dataProviderClass" diye olan class var bunu kullanarak, olusturdugumuz "DataProviderUtils" classını görecek???
      "dataProviderClass = DataProviderUtils.class"=>"DataProviderUtils.class"ı "dataProviderClass" gibi yap

      NOT:"extend", "object olusturma","inheritance" yapmadan, olusturdugumuz method(musteriVerileri) hangi
          sınıfta (DataProviderUtils) ise o sınıfa gidip görecek.
 */

 //        musteriVerileri
   @Test(dataProvider = "musteriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriVerileriTesti(String username,String password,String sube){
       System.out.println("Username = "+ username+ ",Password :"+password+ ",Sube :"+sube);

   }


//          musteriHizmetleriVerileri
       @Test(dataProvider = "musteriHizmetleriVerileri",dataProviderClass = DataProviderUtils.class)
       public void musteriHizmetleriGirisBilgileriTesti(String username,String password){
           System.out.println(username+" | "+password);

     }


//           personelVerileri
       @Test(dataProvider = "personelVerileri",dataProviderClass = DataProviderUtils.class)
       public void personelGirisBilgileriTesti(String username,String password){
          System.out.println(username+" | "+password);

}


//          customerData
    @Test(dataProvider = "customerData",dataProviderClass = DataProviderUtils.class)
    public void customerDataTest(String email,String password){
        System.out.println("EXCEL DATALARI");
        System.out.println(email +" ||| "+password);

    }


}
