package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
public class Driver {

    /*

     private static WebDriver driver;
    //    getDriver() is used to instantiate the driver object
    public static WebDriver getDriver(){
        if (driver==null){
            WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();

//       NOTE: sel 4.5
//         driver = WebDriverManager.chromedriver().create(); //selenium 4.5'den sonrasında böyle kullanılıyor

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); //page'in load olmasını beklemek icin
        driver.manage().window().maximize();
        return driver;
    }
      Once boyle yaptık ama  diger bravzerları ekleyince asagıdaki gibi yaptık.

     */


    //    Driver.getDriver(); methodu -> driver object return eder
    private static WebDriver driver;
    //    getDriver() is used to instantiate the driver object -getDriver(), driver nesnesini başlatmak için kullanılır
    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();  //selenium 4.5'den oncesinde böyle kullanılıyor
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;

            }

//       NOTE: sel 4.5
//         driver = WebDriverManager.chromedriver().create(); //selenium 4.5'den sonrasında böyle kullanılıyor,ama "create()" direk kapattıgı icin "setup()"ı kullanıyoruz.
// WebDriverManager.chromedriver().setup(); ve  driver = new ChromeDriver(); bu ikisin,in yerine yukardaki tek satırda yazmak yeterli  //selenium 4.5'den oncesinde böyle kullanılıyor

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); //page'in load olmasını beklemek icin
        driver.manage().window().maximize();
        return driver;
    }

//    closeDriver() is used to close the driver
    public static void closeDriver(){
//        if driver is already being used(pointing an object)
//        then quit the driver
        if (driver!=null){
            driver.quit();
            driver=null; //driver'ın kesin kapandıgını verir.
        }
    }
}
