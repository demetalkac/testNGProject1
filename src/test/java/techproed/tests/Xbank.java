package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.XBank;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Xbank {
    XBank bankPage;
    @Test
    public void test(){
       bankPage = new XBank();
        Driver.getDriver().get(ConfigReader.getProperty("xyzBank_URL"));

 //   Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login

    //    Click on "Bank Manager Login" button
        bankPage.bankManegerLogBut.click();
    //    Click on "Add Customer" button
        bankPage.addCostmr.click();
    //    Fill inputs and click on "Add Customer" submit button
        Faker faker = new Faker();
        for (int i=0; i<5; i++) {
            bankPage.firstNamAddCus.sendKeys(faker.name().firstName());
            bankPage.lastNamAddCus.sendKeys(faker.name().lastName());
            bankPage.poatCoAddCus.sendKeys(faker.address().zipCode());
            bankPage.addCusButtonAddCus.click();

           try {
               Driver.getDriver().switchTo().alert();
           }catch (Exception ignored){

           }

        }
    //    Accept alert
    //    Add 4 more customers

    //    Click on "Open Account"  button
         bankPage.openAccount.click();
   //    Click on "Process" button
        //    Select customer name
        //    Click on "Customer" dropdown
        //    Click on "Currency" dropdown
    //    Select "Dollar"

        Select select =new Select(bankPage.costName);
        Select select1 =new Select(bankPage.costName);

        for (int i=6; i<11; i++) {
            select.selectByIndex(0);
            select1.selectByIndex(1);
            bankPage.process.click();
           try {
               //    Accept alert
               Driver.getDriver().switchTo().alert().accept();
           }catch (Exception ignored){

           }

        }
    //    Open 4 more accounts

    //    Click on "Customers" button
      bankPage.costomers.click();
    //    Count table row numbers
         int rowSayisi= bankPage.costomerRow.size();
    //    Assert that you created 5 customers
         assertEquals(10,rowSayisi);
    //    Click on "Home" button
          bankPage.homeButton.click();
    //    Click on "Customer Login" button
           bankPage.customButton.click();
    //    Click on "Your Name" dropdown

    //    Select the any name you created
        Select select2= new Select(bankPage.yourNameDropDown);
        select2.selectByIndex(8);

    //    Click on "Login" button
       bankPage.loginButton.click();
    //    Click on "Deposit" button
        ReusableMethods.waitFor(2);
     WebElement deps= bankPage.depositButton;
     deps.click();
    //    Type 100 into "Amount to be Deposited" input
    bankPage.amount.sendKeys("100");
    //    Click on "Deposit"(Submit) button
       bankPage.depositSubmitButton.click();
    //    Assert that "Deposit Successful" is displayed
          assertTrue(bankPage.depositSaccess.isDisplayed());
    //    Click on "Withdrawal" button
          bankPage.withdrawl.click();
    //    Type 100 into "Amount to be Withdrawn" input
     bankPage.amountWithdraw.sendKeys("100");
    //    Click on "Withdraw"(Submit) button
           bankPage.withdrawSubmitButton.click();
    //    Assert that "Transaction  Successful" is displayed
        assertTrue(bankPage.transactionSaccess.isDisplayed());

    //    Click on "Logout" button
        bankPage.logout.click();
    //    Click on "Home" button
          bankPage.homeButton.click();
    //    Click on "Bank Manager Login" button
        bankPage.bankManneger.click();

    //    Click on "Customers" button

    //    Click on each "Delete" button

    //    Count table row numbers

    //      Assert that number of customers is 0
}
}