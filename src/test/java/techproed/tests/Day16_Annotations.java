package techproed.tests;
import org.testng.annotations.*;

public class Day16_Annotations {
    /*
   suite > test > group > class > method
   @Test : creates test case
   @Before and @After : 5 before and 5 after annotations. The are used to control FLOW and DESIGN of the tests
      (@BeforeSuite, @BeforeClass, @BeforeTest, @BeforeMethod, @BeforeGroups)
   @Ignore  :skip test case
   @Test(enabled = false) :Disable the test case. By default enable=true.
      "enabled = false" bu testi kullanma,calıstırma anlamında.Testleri calıstırınca hic goremeyiz,daha guclu
      bir kullanım "@Ignore"a gore. "@Test(enabled = false)" bu sekilde kullandıgımızda @Test'i run yapan isarette
      ortadan kalkar.
    @Test(priority=number) : prioritize/order test case execution.
    NOTE: Tests that has no priority parameter has a priority of 0. Test(priority=0)
    TestNG test cases runs in alphabetical order by default.
    We should use priority when there are multible test cases in the same class
    -3, 0(ALSO TESTS WITH NO PRIORITY), 4, 9
              ***
    @BeforeSuite :Her bir test suite'den once 1 kere calısır
    @AfterSuite :Her bir test suite'den sonra 1 kere calısır

    @BeforeTest :Her bir test'den(test case ile karıstırmamalı,test set gibi) once 1 kere calısır
    @AfterTest  :Her bir test'den(test case ile karıstırmamalı,test set gibi) sonra 1 kere calısır

    @BeforeClass :Her bir class'dan once 1 kere calısır
    @AfterClass  :Her bir class'dan sonra 1 kere calısır

    @BeforeMethod :Her bir @Test annotation'dan once 1 kere calısır. JUnit'deki karsılıgı;@Before
    @AfterMethod :Her bir @Test annotation'dan sonra 1 kere calısır. JUnit'deki karsılıgı;@After
    -Bu classta 6 tane @Test olusturdugumuz icin 6 kere @BeforeMethod ve 6 kere @AfterMethod goruruz
    */



    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeGroups //cok kullanılmaz
    public  void beforeGrup(){
        System.out.println("Before Groups");
    }

    @BeforeClass //@BeforeClass'i ve @AfterClass "static" olması gerekiyor
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test(priority = 2)
    public void test1() {
        System.out.println("test1");
    }
    @Ignore
    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("test3");
    }

    @Test(priority = 3)
    public void test4() {
        System.out.println("test4");
    }

    @Test(priority = 1,groups = "minor-regression-group")
    public void test5() {
        System.out.println("test5");

    }
    @Test(groups = "minor-regression-group")
    public void test6(){
        System.out.println("test6");
    }
}