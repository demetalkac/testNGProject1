package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import techproed.utilities.Driver;

import java.util.List;

public class XBank {
   public   XBank (){
       PageFactory.initElements(Driver.getDriver(),this);

   }
    @FindBy(xpath = "(//div[@class='center'])[2]")
    public WebElement bankManegerLogBut;

   @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement addCostmr;

   @FindBy(xpath ="//input[@placeholder='First Name']")
    public WebElement firstNamAddCus;

  @FindBy(xpath = "//input[@placeholder='Last Name']" )
    public WebElement lastNamAddCus;

 @FindBy(xpath ="//input[@placeholder='Post Code']" )
    public WebElement poatCoAddCus;

 @FindBy(xpath = "//button[@type='submit']")
    public WebElement addCusButtonAddCus;


 @FindBy(xpath = "//*[@ng-class='btnClass2']")
    public WebElement openAccount;

 @FindBy(id = "userSelect")
    public  WebElement costName;

 @FindBy(id = "currency")
    public  WebElement currency;

 @FindBy(xpath = "//button[@type='submit']")
    public WebElement process;


    @FindBy(xpath = "//*[@ng-class='btnClass3']")
    public WebElement costomers;

    @FindBy(xpath = "//tbody//td[1]")
    public List<WebElement> costomerRow;

    @FindBy(xpath = "//button[@ng-click='home()']")
    public WebElement homeButton;

    @FindBy(xpath = "//button[@ng-click='customer()']")
    public WebElement customButton;

    @FindBy(id = "userSelect")
    public  WebElement yourNameDropDown;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement loginButton;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    public WebElement depositButton;

    @FindBy(xpath = "//input[@ng-model='amount']")
    public WebElement amount;


    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement depositSubmitButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    public  WebElement depositSaccess;


    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    public WebElement withdrawl;

    @FindBy(xpath = "//input[@ng-model1='amount']")
    public WebElement amountWithdraw;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement withdrawSubmitButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    public  WebElement transactionSaccess;


    @FindBy(xpath = "//button[@ng-click='byebye()']")
    public WebElement logout;

    @FindBy(xpath = "//button[@ng-click='manager()']")
    public WebElement bankManneger;

}

