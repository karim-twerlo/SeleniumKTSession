package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P01HomePage extends BasePage {
    public P01HomePage(WebDriver driver) {
        super(driver);
    }
    private final By typo = By.xpath("//*[@href='/typos']");
    private final By ABTest = By.xpath("//*[@href='/abtest']");
    public void checkLoginScreenDisplayedSuccessfully(){
        waitForVisibility(homePageTitle,60);
    }
    public void checkScrolling(){
        elementsValidator(ABTest,typo);
    }
}
