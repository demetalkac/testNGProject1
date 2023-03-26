package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AlloverCommerceHomePage {
  public   AlloverCommerceHomePage(){
      PageFactory.initElements(Driver.getDriver(),this);
  }

  @FindBy(xpath = "//*[text()='Register']")
    public WebElement register;

  @FindBy(id = "reg_username")
    public  WebElement usernameSignUpRegister;

  @FindBy(id = "reg_email")
    public  WebElement emailSignUpRegister;

  @FindBy(id = "reg_password")
    public  WebElement passwordSignUpRegister;

  @FindBy(id = "register-policy")
    public  WebElement agreeBoxSignUpRegister;

  @FindBy(xpath= "//button[@name='register']")
    public  WebElement signUpButtonRegister;


  @FindBy(xpath = "//*[text()='Sign Out']")
  public WebElement signOut;
}
