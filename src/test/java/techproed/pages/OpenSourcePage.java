package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

//   Constructor olustur
    public OpenSourcePage() {
//        Used to initiate the page objects->

        PageFactory.initElements(Driver.getDriver(), this);
// "PageFactory" seleniumdan gelir. Page object model icin kullanılan bir class'tır.
// "initElements()";elementleri initiate yapmak yani baslagıc degeri vermek icin,ve sayfa objeleri cagrıldıgında
//                  "nullPointerException" almamak icin kullanılır.
//  2 parametresi var;ilkine driver digerine "this" konulur
    }


    //PAGE OBJELERİNİ OLUSTUR;
    //   public WebElement username = driver.findElement(By.xpath("//input[@name='username")); TRADITIONAL
    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

}
