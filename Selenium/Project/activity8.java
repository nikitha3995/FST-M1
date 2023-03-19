import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity8 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @Test
    public void exampleTestCase() {

        WebElement userid = driver.findElement(By.xpath("//input[contains(@id,'user_login')]"));
        userid.sendKeys("root");
        WebElement password = driver.findElement(By.xpath("//input[contains(@id,'user_pass')]"));
        password.sendKeys("pa$$w0rd");
        WebElement login = driver.findElement(By.xpath("//input[contains(@id,'wp-submit')]"));
        login.click();
        WebElement title = driver.findElement(By.xpath("//a[@class='ab-item'][contains(.,'Howdy, root')]"));
        String titletext = title.getText();
        // System.out.println(driver.findElement(By.xpath("//a[@class='ab-item'][contains(.,'Howdy, root')]")));
        Assert.assertEquals("Howdy, root", titletext);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
