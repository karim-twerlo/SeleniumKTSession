package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public final By homePageTitle = By.xpath("//*[normalize-space()='Welcome to the-internet']");


    public void ElementsValidator(By... screenLocators) {
        for (By screenLocator : screenLocators) {
            scrollToElement(screenLocator);
            Assert.assertTrue(assertElementDisplayed(screenLocator));
        }
    }
    public void waitForVisibility(By by , int durationIntoSeconds){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationIntoSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public void waitForVisibility(By by ){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public Boolean assertElementDisplayed(By by){
        waitForVisibility(by,50);
        return  driver.findElement(by).isDisplayed();
    }
    public void sendTextToInputField(String text , By by){
        waitForVisibility(by);
        driver.findElement(by).sendKeys(text);
    }
    public void clickOnElement(By element){
        waitForVisibility(element);
        driver.findElement(element).click();
    }
    public void checkText(By element, String text){
        waitForVisibility(element);
        System.out.println(driver.findElement(element).getText());
        Assert.assertTrue(driver.findElement(element).getText().contains(text));
    }
    //////////////////////////////////////////
    /**
     * scroll to specific element
     * Select and selenium support dependency
     *
     */

    /**
     * a method takes a By element and try to scroll to this element
     * return nothing  , take By element
     */
    public void scrollToElement(By element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'})",driver.findElement(element));
    }
    /**
     * a method . will take unlimited number of elements and will try to scroll to them and check if they are displayed
     * take unlimited number of elements , return void
     */
    public void elementsValidator(By... elements){
        for (By value : elements) {
            scrollToElement(value);
            Assert.assertTrue(assertElementDisplayed(value));
        }
    }
    /**
     *
     * method to select from select dropdown using index , value using text
     * will take index or value or text and will select them and return nothen
     */
    public void selectByTextFrmDropdown(String text , By by){
        Select selectFromDropDown = new Select(driver.findElement(by));
        selectFromDropDown.selectByVisibleText(text);
    }
    public void selectByValueFrmDropdown(String value , By by){
        Select selectFromDropDown = new Select(driver.findElement(by));
        selectFromDropDown.selectByValue(value);
    }
    public void fluentWait(By by, int seconds){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
/*
waits :
implicitly wait ==>         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
in project level , no such element , will hold before interacting with any element , slow down your project
explicitly wait ==> our way , invisiblity
 */

}
