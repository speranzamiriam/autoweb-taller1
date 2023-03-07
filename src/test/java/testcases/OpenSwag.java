package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import prueba.LoginPage;

public class OpenCart {

    static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
    }

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.selectOptions("Login");
        Assert.assertTrue(loginPage.isLoadedTextBox());
        loginPage.enterCredentials("montesmoraleserick@gmail.com", "Prueba.01");
        String value = loginPage.getSuccessValue();
        if (value.equals("My Account")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void loginWithoutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.selectOptions("Login");
        Assert.assertTrue(loginPage.isLoadedTextBox());
        loginPage.enterCredentials("", "Prueba.01");
        String value = loginPage.getErrorValue();
        if (value.equals("Warning: No match for E-Mail Address and/or Password.")) {
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
