package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.Calendar;

public class Config {

    public WebDriver driver;

    private String BASE_URL = "https://wordpress.org/";
    private String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/drivers/chromedriver";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }


    @AfterMethod ()
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE ){
            try {
                String fileName = String.format("Screenshot-%s.jpg", Calendar
                        .getInstance().getTimeInMillis());
                TakesScreenshot ts = (TakesScreenshot)driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                String dest="./screenshot/"+ fileName;
                File snapshotDest =new File(dest);
                FileUtils.copyFile(source, snapshotDest);
                Reporter.log("<br><img src='"+snapshotDest+"' height='300' width='300'/><br>");
            } catch (Exception e) {
                throw new RuntimeException("Failed to take screenshot !", e);
            }
        }
        driver.close();
        driver.quit();
    }


}
