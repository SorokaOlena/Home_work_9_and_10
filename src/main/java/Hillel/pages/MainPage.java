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

    private String item ="Blouse";


    private WebDriver driver;

    private final static String TITLE_PROCEED_TO_CHECKOUT = "//*[@title='Proceed to checkout']";
    private final static String TITLE_PROCEED_TO_CHECKOUT2 = "//*[@id=\"total_price\"]['$56.00']";

    @FindBy(xpath = "//header[@id='header']//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//header[@id='header']//button[@name='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='center_column']//a[contains(text(),'List')]")
    private WebElement listView;

    @FindBy(xpath = "//*[@class='right-block-content row']")
    private WebElement itemView;

    @FindBy(xpath = "//tr[@class='cart_item last_item first_item address_0 odd']//a[@title='Add']")
    private WebElement addButton;


//***************
    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    private WebElement womenTab;

    @FindBy(css = "#block_top_menu > ul > li.sfHoverForce > a")
    private WebElement dressesTab;

    @FindBy(id = "search_query_top")
    private WebElement search;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement submitButton;
//
 //   @FindBy(xpath = "//*[@class='right-block-content row']")
 //   private WebElement itemView;
//
 //   @FindBy(className = "icon-th-list")
 //   private WebElement listView;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addCartButton;

    @FindBy(xpath = TITLE_PROCEED_TO_CHECKOUT)
    private WebElement proceedCheckout;

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement totalSum;

    @FindBy(xpath = "//*[contains(@href,'controller=my-account')]")
    private WebElement singIn;

    @FindBy(xpath = "//*[@title='Contact Us']")
    private WebElement contactUs;
// --------------------------------------------------------------------------
///    private By tshirtsTab = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
//    private By sizeLcheckbox = By.id("layered_id_attribute_group_3");
//
//    public MainPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public MainPage openTShirtTab(){
//        this.driver.findElement(tshirtsTab).click();
//        return this;
//    }
//
//    public MainPage selectSizeL(){
//        this.driver.findElement(sizeLcheckbox).click();
//        return this;
//    }

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    @CacheLookup
    private WebElement tShirtTab;

    @FindBy(id = "layered_id_attribute_group_3")
    private WebElement sizeLcheckbox;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public MainPage fillSearch(){
        searchField.sendKeys(item);
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


    /////**********
    public MainPage selectSizeL(){
        sizeLcheckbox.click();
        return this;
    }





    public MainPage openTShirtTab() {
        tShirtTab.click();
        return this;
    }
    // --------------------------------------------------------------------------

    public MainPage clickWomenTab() {
        womenTab.click();
        return this;
    }

    public MainPage clickDressesTab() {
        dressesTab.click();
        return this;
    }

    public MainPage clickTShirtTab() {
        tShirtTab.click();
        return this;
    }

    //    public SignInPage clickSignIn(){
//        singIn.click();
//        return new SignInPage(driver);
//    }
    public void clickAddToCart(){
        addCartButton.click();
    }

//    public void navigateToItemView () {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(itemView).build().perform();
//    }

    public void scrollToItem(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", itemView);
    }
    public void clickProceedToCheckout() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.
                        xpath(TITLE_PROCEED_TO_CHECKOUT))).click();
    }

    public void clickProceedToCheckout2() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.
                        xpath(TITLE_PROCEED_TO_CHECKOUT2))).getText();
    }

    public String getTotalPrice(){
        return totalSum.getText();
    }
}
