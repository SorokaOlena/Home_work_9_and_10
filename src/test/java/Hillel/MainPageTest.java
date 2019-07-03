package Hillel;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {


    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        // win mac linux
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        this.mainPage = new MainPage(this.driver);
    }

    @Test
    public void Regestration() {
       Assert.assertTrue(
                mainPage.openMainPage()
                        .openLoginWindow()
                        .fillEmailAddress()
                        .clickCreateAnAccount()
                        .fillPersonalFirsrName()
                        .fillPersonalLastName()
                        .fillPassword()
                        .fillAddressFirsrName()
                        .fillAddressLastName()
                        .fillAddress()
                        .fillCity()
                        .fillZipCode()
                        .fillMobilePhone()
                        .fillAddressAlias()
                        .clickRegisterButton()
                        .isErrorMesage());
    }

   @After
    public void cleanup(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
