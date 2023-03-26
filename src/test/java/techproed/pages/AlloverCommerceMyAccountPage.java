package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AlloverCommerceMyAccountPage {
    public AlloverCommerceMyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[text()='Addresses'])[1]")
    public WebElement addressesMyAccount;

    @FindBy(id = "MyAccountPage")
    public WebElement usernameMyAccountSignIn;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordMyAccountSignIn;

    @FindBy(xpath = "//input[@id='rememberme']")
    public WebElement rememberMeMyAccountSignIn;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signInButtonMyAccountSignIn;


    }

