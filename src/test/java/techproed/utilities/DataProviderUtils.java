package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

// ===================TURKCE=========******DATA PROVİDER İCİN ÖRNEK AMACLI YAPTIK***********
//=================Burdaki methodları "DataProviderTestC" classında cektik=================

    @DataProvider
    public Object[][] musteriVerileri(){
        Object [][] musteriGirisBilgileri = {
                {"menejer1","12345","bayrampasa"},
                {"menejer2","67432","cebeci"},
                {"menejer3","98640","karsıyaka"}
        };
        return musteriGirisBilgileri;
    }

    @DataProvider
    public Object[][] musteriHizmetleriVerileri(){
        Object [][] musteriHizmetleriGirisBilgileri = {
                {"aise1","30945"},
                {"ali2","43122"},
                {"mehmet3","90040"}
        };
        return musteriHizmetleriGirisBilgileri;
    }


    @DataProvider
    public Object[][] personelVerileri(){
        Object [][] personelGirisBilgileri = {
                {"ahmet1","nj98"},
                {"saliha2","hf132"},
                {"fatih3","as81"},
                {"narin3","9kl81"}
        };
        return personelGirisBilgileri;
    }


 // Excelden dataprovider a data gelir
 //  Burdan da Test case'e gönderebiliriz

    @DataProvider
    public Object[][] customerData(){

        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);
        Object [][] customerCredentials = excelUtils.getDataArrayWithoutFirstRow();
        return customerCredentials;
    }


}
