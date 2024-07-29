package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P002AvocadoeWelcomePage extends BasePage {

    public P002AvocadoeWelcomePage(WebDriver driver) {
        super(driver);
    }
    private final By avocadoLogoFromHome = By.xpath("//*[@alt='avocado icon']");
    private final By unAssignedBtn = By.xpath("(//*[@type='button'])[20]");
    public void checkHomeScreenLoadedSuccessfully(){
        waitForVisibility(avocadoLogoFromHome);
        Assert.assertEquals("Unassigned",driver.findElement(unAssignedBtn).getText(),"can't find element");
    }
}
