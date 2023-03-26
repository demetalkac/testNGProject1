package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.FirstBricPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class FirstBricTest {

  FirstBricPage firstBricPage;

  @Test
    public void firstBrickTest(){
      firstBricPage = new FirstBricPage();
//   Go to url https://live.mersys.io/
      Driver.getDriver().get(ConfigReader.getProperty("first_brick_url"));

//   Click on "Kullanıcı Adı" button and send the user name "firstbricksogrencisiyim64@gmail.com"
     firstBricPage.kullanıcıAdı.click();
     firstBricPage.kullanıcıAdı.sendKeys(ConfigReader.getProperty("first_brick_kullanici"));
//   Click on "Parola" button and send the parola "Okulum+0448"
    firstBricPage.parola.click();
    firstBricPage.parola.sendKeys(ConfigReader.getProperty("first_brick_parola"));

//   Click on the "Gris Yap" button
    firstBricPage.grisButonu.click();


  }

  //  Given
  //            Go to  url https://live.mersys.io/
  //        When
  //           Click on "Kullanıcı Adı" button
  //        And
  //            send the user name "firstbricksogrencisiyim64@gmail.com"
  //       And
  //           Click on "Parola" button
  //       And
  //           send the parola "Okulum+0448"
  //       And
  //           Click on the "Gris Yap" button
  //       Then
  //            Verify login successful

}
