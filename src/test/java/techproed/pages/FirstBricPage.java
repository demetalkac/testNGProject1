package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class FirstBricPage {

    public FirstBricPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@data-placeholder='Kullanıcı Adı']")
    public WebElement kullanıcıAdı;

    @FindBy(xpath = "//input[@data-placeholder='Parola']")
    public   WebElement parola;

    @FindBy(xpath = "//span[text()=' GİRİŞ YAP ']")
    public WebElement grisButonu;
}
