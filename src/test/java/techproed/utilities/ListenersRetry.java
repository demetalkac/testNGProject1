package techproed.utilities;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenersRetry implements IRetryAnalyzer {

   /*
     NOT:Normalde bir test case calıstırdık ve fail etti ise biz extra bir daha calıstırmazsak o test tekrar calısmaz.
    Eger boyle testlerimiz var ise biz kalan testimiz otomatik bir daha calıssın istersek bu classı kullanarak ayarlayabiliriz.
     -bu class, eger test case'ler fail eder ise tekrar fail eden caseleri calıstırmak icin kullanıyoruz.
       Eger varsa böyle test caseler;
        1- bu sınıf ile once baglantı kuruyoruz:
       ornegin; @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class) VEYA
       2-"xml" ile kullanARAK YAPARIZ. FAKAT xml icine direk "ListenersRetry" seklinde koyamıyoruz.Cunku bu sınıfı "IRetryAnalyzer"
       implements yaptıgımız icin olmuyor.Bunu kullanabilir hale getirmek icin baska bir interface olusturmuslar,
       ismi "IAnnotationTransformer". "ListenersRetryAnalyzer(olusturdugumuz classınismini biz koyuyoruz)" isminde
       olusturdugumuz classı, "IAnnotationTransformer" e implements yaparak kullanabilir hale getirmis oluyoruz.

       maxRetryCount : Fail olan testin fazladan calısma sayısı,,buna 2 yazsak extra 2 kez, 3 yazsak extra 3 kez calısır.
                         --------------
       -fail eden testi buraya 1 yazdıgımız icin 1 kere calıstırır. 2 YAZSAK 2 DEFA CALISTIRIR.
       -Halen fail ederse "NoSuchElementException" verir.
       not: bu class yeterince dinamik degil cünkü bu klası kullanabilmek icin kullanacagımız sınıfları bu sınıf ile
        tek tek iliskilendirmek lazım.Onun icin ismini "ListenersRetryAnalyzer" koydugumuz class ile dha dinamik yaptık.
        "ListenersRetryAnalyzer" tüm framework'a uygular.
    */


    private int retryCount = 0;
    private static final int maxRetryCount = 1; //fail eden testi buraya 1 yazdıgımız icin 1 kere calıstırır,2 yazsak 2 kere calıstırır
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}