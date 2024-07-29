package base;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;


public class BaseTest {
    public WebDriver drive;
    @BeforeClass
    //open the driver and get google url
    public void startSession(){
        System.out.println("Session starting....");
        drive = new ChromeDriver();
        drive.get("https://test.avocad0.dev/login"); // navigate to the url and wait till page full loaded
        drive.manage().window().maximize();
//        drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        System.out.println("i am into login page");

    }
    ///ru tests
    @AfterClass
    public void tearDown(){
        System.out.println("after");
        if(drive!= null){
//            drive.quit();

        }

    }
    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot cam = (TakesScreenshot) drive;
            File srcFile = cam.getScreenshotAs(OutputType.FILE);
            try {
                File destFile = new File("resources/java/" + result.getName() + ".png");
                FileHandler.copy(srcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
