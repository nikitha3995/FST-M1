package Live_Project_taskkeep;

import io.appium.java_client.MobileBy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity1 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceId","77e9ed81");
        caps.setCapability("appPackage","com.google.android.apps.tasks" );
        caps.setCapability("appActivity",".ui.TaskListsActivity" );
        caps.setCapability("noReset",true);

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(serverURL,caps);
    }

    @Test
    public void createTasks(){
        MobileElement newList = driver.findElementById("tasks_fab");
        newList.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,20);
        MobileElement taskTitle = driver.findElementById("add_task_title");
        wait.until(ExpectedConditions.elementToBeClickable(taskTitle));
        taskTitle.click();
        taskTitle.sendKeys("Complete Activity with Google Tasks");
        driver.findElementById("add_task_done").click();

        newList = driver.findElementById("tasks_fab");
        newList.click();

        driver.findElementById("add_task_title").click();
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google task");
        driver.findElementById("add_task_done").click();

        newList = driver.findElementById("tasks_fab");
        newList.click();

        driver.findElementById("add_task_title").click();
        driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google task");
        driver.findElementById("add_task_done").click();
        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"),3));

        List<MobileElement> taskList = driver.findElementsById("task_name");
        for(MobileElement taskEntry:taskList){
            System.out.println(taskEntry.getText());
        }

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
