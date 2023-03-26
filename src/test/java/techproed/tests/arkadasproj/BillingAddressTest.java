package techproed.tests.arkadasproj;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import techproed.pages.AlloverCommerceAddressesPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class BillingAddressTest {
    /*
    User should go to https://www.allovercommerce.com/
    User story ID :US_003
    Test Cace ID : TC 001
    Test Objective : "User should add Billing Address.
                     (My Account > Adressses > Billing Address)"
     Pre-Condition :
     No :1:User should enter First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code and Phone Number.
         2:The registered email address should be filled in automatically.
         3:After clicking 'Save Address', the Billing Address should be added.
     Test Data:
     Expected Result:
     Actual Result:
     Status:

     */
   AlloverCommerceAddressesPage addressesPage;
    Faker faker;


    @Test
    public void addressesBillingAddressPositiveTest(){
        addressesPage = new AlloverCommerceAddressesPage();
        faker = new Faker();
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_address_url"));
        addressesPage.nameBillingAddress.sendKeys(faker.name().fullName());
        addressesPage.addressBillingAddress.sendKeys(faker.address().firstName());
        addressesPage.addressBillingAddress.sendKeys(faker.address().lastName());
        addressesPage.addressBillingAddress.sendKeys(faker.address().streetAddress());
        addressesPage.addressBillingAddress.sendKeys(faker.address().city());
        addressesPage.addressBillingAddress.sendKeys(faker.address().state());
        addressesPage.addressBillingAddress.sendKeys(faker.address().zipCode());
        addressesPage.addressBillingAddress.sendKeys(faker.phoneNumber().phoneNumber());
        addressesPage.addressBillingAddress.sendKeys(faker.address().country());
        addressesPage.cityBillingAddress.sendKeys(faker.address().city());
        addressesPage.addBillingAddress.click();

    }
}
// First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code and Phone Number.