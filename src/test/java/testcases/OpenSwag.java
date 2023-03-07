package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import prueba.LoginPage;
import prueba.LoginPageSwag;

public class OpenSwag {

    static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
    }

    @Test
    public void loginExitoso() {
        LoginPageSwag loginPage = new LoginPageSwag(driver);
        loginPage.open();
        loginPage.enterCredentialsPorId("standard_user", "secret_sauce");
        String value = loginPage.getSuccessValue();
        if (value.equals("Products")) {
            Assert.assertTrue(true);
       } else {
           Assert.assertTrue(false);
       }
    }

    @Test
    public void loginWithoutUser() {
        LoginPageSwag loginPage = new LoginPageSwag(driver);
        loginPage.open();
        loginPage.enterCredentialsPorId("risa", "123456");
        String value = loginPage.getErrorValue();
        if (value.equals("Epic sadface: Username and password do not match any user in this service")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @AfterMethod
    public void close() {
        driver.close();
    }

    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
