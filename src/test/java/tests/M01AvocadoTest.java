package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P001Avocado;
import pages.P002AvocadoeWelcomePage;

public class M01AvocadoTest extends BaseTest {
    P001Avocado login ;
    P002AvocadoeWelcomePage home;
    @BeforeClass
    public void initObjects(){
        login = new P001Avocado(drive);
        home = new P002AvocadoeWelcomePage(drive);
    }
    @Test
    public void loginSuccessfullyToAvocado(){
        login.loginToAvocado("karim.salem@twerlo.com","123456789","Automation");
        home.checkHomeScreenLoadedSuccessfully();
    }
}
