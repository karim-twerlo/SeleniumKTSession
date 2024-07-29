package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P001Avocado;
import pages.P002AvocadoeWelcomePage;
import pages.P04AvocadoWorkspace;

public class M04WorkspaceTest extends BaseTest {
    P001Avocado login;
    P002AvocadoeWelcomePage home;
    P04AvocadoWorkspace work;

    @BeforeClass
    public void initObjects() {
        login = new P001Avocado(drive);
        home = new P002AvocadoeWelcomePage(drive);
        work = new P04AvocadoWorkspace(drive);
    }


    @Test
    public void TC_01ValidateWorkspace() {
        login.loginToAvocado("karim.salem@twerlo.com", "123456789", "Automation");
        home.checkHomeScreenLoadedSuccessfully();
        work.navigateToProfileWorkspace();
        work.validateWorkspaceElements();
        work.validateChangePassword();
        work.checkWorkSpaceProfile();
    }
}