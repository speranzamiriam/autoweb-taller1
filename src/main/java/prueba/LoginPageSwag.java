package prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPageSwag extends BasePage {

    public LoginPageSwag(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://opencart.abstracta.us/");
        driver.manage().window().maximize();
    }

    public void selectOptions(String value) {
        driver.findElement(By.xpath("//a[contains(@title,'My Account')]")).click();
        WebElement content = driver.findElement(By.id("top-links"));
        List<WebElement> list = content.findElements(By.tagName("a"));
        for (WebElement element : list) {
            if (element.getText().equals(value)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
                break;
            }
        }
    }

    public void enterCredentials(String user, String pass) {
        driver.findElement(By.id("input-email")).sendKeys(user);
        driver.findElement(By.id("input-password")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public boolean isLoadedTextBox() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).isDisplayed();
    }

    public String getSuccessValue() {
        WebElement value = driver.findElement(By.xpath("//h2[text()='My Account']"));
        return value.getText();
    }

    public String getErrorValue() {
        WebElement error = driver.findElement(By.xpath("//div[contains(@class,'alert')]"));
       return error.getText();
    }


}
