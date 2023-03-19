import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity9 {
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
        WebElement joblisting = driver.findElement(By.xpath("(//div[contains(@class,'wp-menu-image dashicons-before dashicons-admin-post')])[2]"));
        joblisting.click();
        WebElement newjob = driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/wp-admin/post-new.php?post_type=job_listing'][contains(.,'Add New')]"));
        newjob.click();
        WebElement emailid = driver.findElement(By.xpath("//input[contains(@id,'_application')]"));
        emailid.sendKeys("murthynikitha8@gmail.com");
        WebElement companyurl = driver.findElement(By.xpath("//input[contains(@id,'_company_website')]"));
        companyurl.sendKeys("www.ibm.com");
        WebElement location = driver.findElement(By.xpath("//input[contains(@id,'_job_location')]"));
        location.sendKeys("bangalore");
        WebElement posttitle = driver.findElement(By.xpath("//textarea[contains(@id,'post-title-0')]"));
        posttitle.sendKeys("tester");
        WebElement publish = driver.findElement(By.xpath("//button[@type='button'][contains(.,'Publish…')]"));
        publish.click();
        WebElement doublepublish = driver.findElement(By.xpath("//button[contains(@class,'components-button editor-post-publish-button editor-post-publish-button__button is-primary')]"));
        doublepublish.click();
        driver.get("https://alchemy.hguy.co/jobs/job/tester-20/");
        //WebElement viewjob = driver.findElement(By.xpath("//a[@class='components-button is-secondary']"));
       // viewjob.click();
        WebElement job = driver.findElement(By.xpath("//h1[@class='entry-title'][contains(.,'tester')]"));
        String text = job.getText();
        System.out.println(text);
        Assert.assertEquals("tester", text);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
