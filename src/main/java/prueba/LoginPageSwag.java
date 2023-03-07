package prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPageSwag extends BasePage {

    public LoginPageSwag(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    public void enterCredentialsPorId(String user, String pass) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.name("login-button")).click();
    }

    public boolean isLoadedTextBox() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).isDisplayed();
    }

    public String getSuccessValue() {

        WebElement value=  driver.findElement(By.xpath("//div[@id='header_container']/div[2]/span"));
        return value.getText();
    }

    public String getErrorValue() {
        WebElement error =driver.findElement(By.xpath("//div[@id='login_button_container']/div/form/div[3]/h3"));
       return error.getText();
    }


}
