package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class ListenersTestng implements ITestListener {
    WebDriver driver;
    String filePath = System.getProperty("user.dir") + "/screenshots/";



    public void onStart(ITestContext context) {
        System.out.println("Starting the test cases");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Ending the test cases");
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailure (ITestResult result){
        System.out.println("name of the testcase failed:"+result.getName());

    }

    public void onTestStart(ITestResult result) {
        System.out.println("name of the testcase started:"+result.getName());

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("name of the testcase passed:"+result.getName());
    }

}
