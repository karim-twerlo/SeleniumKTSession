package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01HomePage;

public class M01HomeTest extends BaseTest {
    P01HomePage home;
    @BeforeClass
    public void initObject(){
        home =new P01HomePage(drive);
    }
    @Test
    public void tc_01calidateHomeScreen(){
        home.checkLoginScreenDisplayedSuccessfully();
    }
    @Test
    public void tc_02validateScrollingBehavior(){
        home.checkScrolling();
    }
}
