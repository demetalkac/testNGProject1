package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AlloverCommerceAddressesPage {
   public AlloverCommerceAddressesPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

/*


    @FindBy(xpath = "(//table//tbody//tr[1]//td[1])[1]")
    public WebElement nameBillingAddress;


   @FindBy(xpath = "(//table//tbody//tr[2]//td[1])[1]")
    public WebElement addressBillingAddress;

   @FindBy(xpath = "(//table//tbody//tr[3]//td[1])[1]")
    public WebElement cityBillingAddress;

   @FindBy(xpath = "(//*[text()='Add'])[1]")
    public WebElement addBillingAddress;

*/
    @FindBy(xpath = "//*[text()='Name:'][1]")
     public WebElement nameBillingAddress;

    @FindBy(xpath = "//*[text()='Address:'][1]")
    public WebElement addressBillingAddress;

    @FindBy(xpath = "//*[text()='City:'][1] ")
    public WebElement cityBillingAddress;

    @FindBy(xpath = "(//*[text()='Add'])[1]")
    public WebElement addBillingAddress;


}
