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

public class activity7 {
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

        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/post-a-job/'][contains(.,'Post a Job')]")).click();
        driver.findElement(By.xpath("//input[contains(@id,'create_account_email')]")).sendKeys("murthynikitha8@gmail.com");
        driver.findElement(By.xpath("//input[contains(@id,'job_title')]")).sendKeys("tester");
        //driver.findElement(By.xpath("//html[@lang='en-US'][contains(.,'.mce-content-body div.mce-resizehandle {position: absolute;border: 1px solid black;box-sizing: content-box;background: #FFF;width: 7px;height: 7px;z-index: 10000}.mce-content-body .mce-resizehandle:hover {background: #000}.mce-content-body img[data-mce-selected],.mce-content-body hr[data-mce-selected] {outline: 1px solid black;resize: none}.mce-content-body .mce-clonedresizable {position: absolute;outline: 1px dashed black;opacity: .5;filter: alpha(opacity=50);z-index: 10000}.mce-content-body .mce-resize-helper {background: #555;background: rgba(0,0,0,0.75);border-radius: 3px;border: 1px;color: white;display: none;font-family: sans-serif;font-size: 12px;white-space: nowrap;line-height: 14px;margin: 5px 10px;padding: 5px;position: absolute;z-index: 10001}.mce-visual-caret {position: absolute;background-color: black;background-color: currentcolor;}.mce-visual-caret-hidden {display: none;}*[data-mce-caret] {position: absolute;left: -1000px;right: auto;top: 0;margin: 0;padding: 0;}.mce-content-body .mce-offscreen-selection {position: absolute;left: -9999999999px;max-width: 1000000px;}.mce-content-body *[contentEditable=false] {cursor: default;}.mce-content-body *[contentEditable=true] {cursor: text;}')]")).sendKeys("adding details for the sake of job");
        driver.findElement(By.xpath("//label[text()='Description']")).click();
        driver.findElement(By.id("job_description_ifr")).sendKeys("Automation Tester");
        driver.findElement(By.xpath("//input[contains(@id,'application')]")).sendKeys("murthynikitha8@gmail.com");
        driver.findElement(By.xpath("//input[contains(@id,'company_name')]")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[contains(@name,'submit_job')]")).click();
        sleep(60);


    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
