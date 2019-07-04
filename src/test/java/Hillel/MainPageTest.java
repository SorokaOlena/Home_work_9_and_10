package Hillel;


import Hillel.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    public void setupMainPage() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void canCheckTotalPriceForTShirt() {
        mainPage.fillSearch()
                .clickSearchButton()
                .clickListView();


  //      mainPage.clickTShirtTab();
        mainPage.scrollToItem();
        mainPage.navigateToItemView();
        mainPage.clickAddToCart();

        mainPage.clickProceedToCheckout();
        mainPage.clickAddButton();
        mainPage.clickProceedToCheckout2();

        String actualResult = mainPage.getTotalPrice();
  //      String expectedResult = "$18.51";
        String expectedResult = "$56.00";

       // Assert.assertEquals("Actual result is: " + actualResult + " Expected result is: " + expectedResult, expectedResult, actualResult);
        Assert.assertEquals( expectedResult, actualResult);

    }
}
