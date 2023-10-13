package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day16_SoftAssert {
    @Test
    public void softAssertTest(){

//      SoftAssert objesi olustur
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Line 11 Code");
        softAssert.assertEquals(3,5); //FAILS
        System.out.println("Line 13 Code");
        softAssert.assertEquals("apple", "orange");  //FAILS
        System.out.println("Line 15 Code");
        softAssert.assertTrue(false); //FAILS
        System.out.println("Line 17 Code");
        softAssert.assertAll(); //Marking the test case as FAİLED or PASSED
    }
    /*
    assertAll(); En sonda kullanmazsak assertAll()'i bütün assertions 'lar gecer ve fail olanı göremeyiz.
     Bu nedenle softassertion yaparken kullanmayı unutmamalıyız.

     */
}
