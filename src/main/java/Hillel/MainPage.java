package Hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class MainPage {
        private static final String MAIN_PAGE_URL ="http://automationpractice.com";
        private WebDriver driver;


        private String email = "sorotschenja" +Math.random()+ "@gmail.com";
        private String firstName = "Soroka";
        private String lastName = "Olena";
        private String password = "olenochka";
        private String address = "Street address, P.O. Box, Company name";
        private String city = "Kyiv";
        private String zipCode = "12345";
        private String mobilePhone = "380961234567";


        private By loginButton = By.xpath("//*[@id='header']//a[@class='login'][@title='Log in to your customer account']");
        private By fieldEmailAddress = By.xpath("//*[@id='columns']//input[@id='email_create']");
        private By submitCreateButton = By.xpath("//div[@id='columns']//*[@id='create-account_form']//button[@id='SubmitCreate']");
        private By fieldPersonalFirsrName =By.xpath("//form[@id='account-creation_form']//input[@id='customer_firstname']");
        private By fieldPersonalLastName  =By.xpath("//form[@id='account-creation_form']//input[@id='customer_lastname']");
        private By filedPassword =By.xpath("//form[@id='account-creation_form']//input[@id='passwd']");
        private By fieldAddressFirsrName =By.xpath("//form[@id='account-creation_form']//input[@id='firstname']");
        private By fieldAddressLastName  =By.xpath("//form[@id='account-creation_form']//input[@id='lastname']");
        private By fieldAddress  =By.xpath("//form[@id='account-creation_form']//input[@id='address1']");
        private By fieldCity =By.xpath("//form[@id='account-creation_form']//input[@id='city']");
        private By fieldZipCode =By.xpath("//form[@id='account-creation_form']//input[@id='postcode']");
        private By fieldMobilePhone =By.xpath("//form[@id='account-creation_form']//input[@id='phone_mobile']");
        private By fieldAdressAlias =By.xpath("//form[@id='account-creation_form']//input[@id='alias']");
        private By registerButton =By.xpath("//form[@id='account-creation_form']//button[@id='submitAccount']");
        private By errorMesage =By.xpath("//div[@class='alert alert-danger']//p[contains(text(),'There are 2 errors')]");



        public MainPage(WebDriver driver) {
            this.driver = driver;
        }

        public MainPage openMainPage(){
            this.driver.navigate().to(MAIN_PAGE_URL);
            return this;
        }

        public MainPage openLoginWindow(){
            this.driver.findElement(loginButton).click();
            return this;
        }

        public MainPage fillEmailAddress(){
            this.driver.findElement(fieldEmailAddress).sendKeys(email);
            return this;
        }

        public MainPage clickCreateAnAccount(){
            this.driver.findElement(submitCreateButton).click();
            return this;
        }

        public MainPage fillPersonalFirsrName(){
            this.driver.findElement(fieldPersonalFirsrName).sendKeys(firstName);
            return this;
        }

        public MainPage fillPersonalLastName (){
            this.driver.findElement(fieldPersonalLastName).sendKeys(lastName);
            return this;
        }

        public MainPage fillPassword (){
            this.driver.findElement(filedPassword).sendKeys(password);
            return this;
        }

        public MainPage fillAddressFirsrName(){
            this.driver.findElement(fieldAddressFirsrName).sendKeys(firstName);
            return this;
        }

        public MainPage fillAddressLastName (){
            this.driver.findElement(fieldAddressLastName).sendKeys(lastName);
            return this;
        }

        public MainPage fillAddress (){
            this.driver.findElement(fieldAddress).sendKeys(address);
            return this;
        }


        public MainPage fillCity (){
            this.driver.findElement(fieldCity).sendKeys(city);
            return this;
        }

        public MainPage fillZipCode (){
            this.driver.findElement(fieldZipCode).sendKeys(zipCode);
            return this;
        }

        public MainPage fillMobilePhone (){
            this.driver.findElement(fieldMobilePhone).sendKeys(mobilePhone);
            return this;
        }

        public MainPage fillAddressAlias (){
            this.driver.findElement(fieldAdressAlias).sendKeys(address);
            return this;
        }

        public MainPage clickRegisterButton(){
            this.driver.findElement(registerButton).click();
            return this;
        }

        public boolean isErrorMesage(){
           return this.driver.findElement(errorMesage).isDisplayed();
       }
    }


