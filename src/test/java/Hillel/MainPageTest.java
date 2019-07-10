package Hillel;


import Hillel.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    public void setupMainPage() {
        mainPage = new MainPage(driver);
        mainPage.fillSearch()
                .clickSearchButton()
                .clickListView()
                .clickAddToCart();

 //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!чому я ці 3 рядка не можу написати без mainPage?!!!!!!!!!!!!!!!!!!!!
        mainPage.clickProceedToCheckout();
        mainPage.clickAddButton();
        mainPage.clickProceedToCheckout2();
    }
     @Test
      public void Test1 (){
         String actualResult1 = mainPage.getCardTotal();
         String expectedResult1 = "$54.00";
            Assert.assertEquals( expectedResult1, actualResult1,"getCardTotal");

          String actualResult2 = mainPage.getTotalProduct();
          Assert.assertEquals(expectedResult1,actualResult2,"getTotalProduct" );

          String actualResult3 = mainPage.getTotalShipping();
          String expectedResult3 = "$2.00";
          Assert.assertEquals(expectedResult3,actualResult3,"getTotalShipping");

          String actualResult4 = mainPage.getTotalPriceWithoutTax();
          String expectedResult4 = "$56.00";
          Assert.assertEquals(expectedResult4,actualResult4,"getTotalPriceWithoutTax");

          String actualResult5 = mainPage.getTax();
          String expectedResult5 = "$0.00";
          Assert.assertEquals(actualResult5,expectedResult5,"getTax");

         String actualResult6 = mainPage.getTotalPrice();
         Assert.assertEquals( expectedResult4, actualResult6,"getTotalPrice");

         mainPage.clickDeleteButton();
         mainPage.clickProceedToCheckout3();
         mainPage.clickProceedToCheckout3();



        }
//    @Test
//    public void Test2 (){
//        String actualResult2 = mainPage.getTotalPrice();
//        String expectedResult2 = "$56.00";
//        Assert.assertEquals( expectedResult2, actualResult2);
//    }

    }

