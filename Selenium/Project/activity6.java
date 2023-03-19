import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait.*;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class activity6 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void exampleTestCase() throws InterruptedException{


        WebElement jobs = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/'][contains(.,'Jobs')]"));
        jobs.click();
        String title = driver.getTitle();
        System.out.println(title);
        WebElement searchpad = driver.findElement(By.xpath("//input[contains(@id,'search_keywords')]"));
        searchpad.sendKeys("Banking");
        WebElement searchjobs = driver.findElement(By.xpath("//input[contains(@value,'Search Jobs')]"));
        searchjobs.click();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'BankingTester2')]")));
        driver.findElement(By.xpath("//h3[contains(.,'BankingTester2')]")).click();
        sleep(60);
        //WebDriverWait applywait = new WebDriverWait (driver, Duration.ofSeconds(5));
        //applywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@value,'Apply for job')]")));

        WebElement applyjob = driver.findElement(By.xpath("//input[contains(@value,'Apply for job')]"));
        applyjob.click();
        sleep(20);
        System.out.println(driver.findElement(By.xpath("//a[@href='mailto:shazra@k.com?subject=Application%20via%20BankingTester2%20listing%20on%20https%3A%2F%2Falchemy.hguy.co%2Fjobs']")));

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
