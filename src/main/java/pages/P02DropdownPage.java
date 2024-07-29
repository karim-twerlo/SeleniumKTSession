package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02DropdownPage extends BasePage {
    public P02DropdownPage(WebDriver driver) {
        super(driver);
    }
    private final By list = By.id("dropdown");
    private final By dropdownFromHome = By.xpath("//*[@href='/dropdown']");
    public void navigateToDropdownPage(){
        waitForVisibility(homePageTitle);
        scrollToElement(dropdownFromHome);
        clickOnElement(dropdownFromHome);
    }
    public void checkDropDown(String text){
        waitForVisibility(list);
        selectByTextFrmDropdown(text,list);
        selectByValueFrmDropdown("1",list);
    }
}
