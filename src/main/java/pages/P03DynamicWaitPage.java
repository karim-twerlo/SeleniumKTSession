package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03DynamicWaitPage extends BasePage {
    public P03DynamicWaitPage(WebDriver driver) {
        super(driver);
    }
    private final By ExampleOne = By.xpath("//*[@href='/dynamic_loading/1']");
    private final By startCTA = By.xpath("//button[normalize-space()='Start']");
    private final By loaderIndicator = By.id("loading");
    private final By helloWord = By.id("finish");
    private void navigateToFirstExample(){
        waitForVisibility(ExampleOne);
        clickOnElement(ExampleOne);
        waitForVisibility(startCTA);
    }
    public void checkDynamicLoading(){
        navigateToFirstExample();
        clickOnElement(startCTA);
        waitForInvisibilityOfElement(loaderIndicator);
        System.out.println("here the element text: " + driver.findElement(helloWord).getText());
    }
    /*
    Actions class , frame , popup , modal  ,Exceptions ,
     read from excelsheet , read from property file ,
     takescreenshot, report using allure ,
     surefire plugin and running from terminal ,
     cross browser , parallel test , tstng actions ,
      maven lif cycle ,
      git and github , github actions
     */

}
