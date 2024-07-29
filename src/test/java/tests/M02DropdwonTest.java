package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01HomePage;
import pages.P02DropdownPage;

public class M02DropdwonTest extends BaseTest {
    P02DropdownPage drop;
    @BeforeClass
    public void initObject(){
        drop =new P02DropdownPage(drive);
    }
    @Test
    public void tc_01CheckSelectByText(){
        drop.navigateToDropdownPage();
        drop.checkDropDown("Option 2");
    }
}
