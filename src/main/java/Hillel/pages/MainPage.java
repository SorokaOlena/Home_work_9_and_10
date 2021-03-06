
package Hillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

  //  private String item ="Blouse";



    private WebDriver driver;

    private final static String TITLE_PROCEED_TO_CHECKOUT = "//*[@title='Proceed to checkout']";
    private final static String TITLE_PROCEED_TO_CHECKOUT2 = "//*[@id=\"total_price\"][contains(text(),'$56.00')]";
    private final static String TITLE_PROCEED_TO_CHECKOUT3 = "//p[@class='alert alert-warning'][contains(text(),'Your shopping cart is empty.')]";

    @FindBy(xpath = "//header[@id='header']//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//header[@id='header']//button[@name='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='center_column']//a[contains(text(),'List')]")
    private WebElement listView;

    @FindBy(xpath = "//*[@class='right-block-content row']")
    private WebElement itemView;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addCartButton;

    @FindBy(xpath = "//div[@id='order-detail-content']//a[@title='Add']")
    private WebElement addButton;

    @FindBy(xpath = TITLE_PROCEED_TO_CHECKOUT)
    private WebElement proceedCheckout;

    @FindBy (xpath = "//span[@id='total_product_price_2_7_0']")
    private WebElement cardTotal;

    @FindBy (xpath = "//td[@id='total_product']")
    private WebElement totalProduct;

    @FindBy (xpath = "//td[@id='total_shipping']")
    private WebElement totalShipping;

    @FindBy (xpath = "//td[@id='total_price_without_tax']")
    private WebElement totalPriceWithoutTax;

    @FindBy (xpath = "//td[@id='total_tax']")
    private WebElement tax;

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement totalSum;

    @FindBy(xpath = "//a[@title=\"Delete\"]")
    private WebElement deletebutton;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    @CacheLookup
    private WebElement tShirtTab;

    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement sizeLcheckbox;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public MainPage fillSearch(String text){
        searchField.sendKeys(text);
        return this;
    }

    public MainPage clickSearchButton(){
        searchButton.click();
        return this;
    }

    public void navigateToItemView () {
        Actions actions = new Actions(driver);
        actions.moveToElement(itemView).build().perform();
    }

    public MainPage clickListView(){
        listView.click();
        return this;
    }

    public MainPage clickAddButton(){
        addButton.click();
        return this;
    }

    public MainPage clickAddToCart(){
        addCartButton.click();
        return this;
    }


    //    public void scrollToItem(){
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].scrollIntoView(true);", itemView);
//    }
    public MainPage clickProceedToCheckout() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.
                        xpath(TITLE_PROCEED_TO_CHECKOUT))).click();
        return this;
    }

    public MainPage clickProceedToCheckout2() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.
                        xpath(TITLE_PROCEED_TO_CHECKOUT2))).getText();
        return this;
    }

    public String getCardTotal (){ return cardTotal.getText(); }
    public String getTotalProduct (){
        return totalProduct.getText();
    }
    public String getTotalShipping(){
        return totalShipping.getText();
    }
    public String getTotalPriceWithoutTax(){
        return totalPriceWithoutTax.getText();
    }
    public String getTax(){
        return tax.getText();
    }
    public String getTotalPrice(){ return totalSum.getText();}

    public void clickDeleteButton(){
        deletebutton.click();
    }

    public MainPage toCheckoutDeletedProduct(){
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TITLE_PROCEED_TO_CHECKOUT3))).getText();
        return this;
    }


    public boolean isErrorMesage(){
        return this.driver.findElement(By.xpath(TITLE_PROCEED_TO_CHECKOUT3)).isDisplayed();
    }

}
