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

        String actualResult1 =mainPage.getCardTotal();
        String expectedResult1 = "$54.00";


        String actualResult2 = mainPage.getTotalPrice();
        String expectedResult2 = "$56.00";


        Assert.assertEquals( expectedResult1, actualResult1);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals( expectedResult2, actualResult2);

    }
}
