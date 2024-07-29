package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.P03DynamicWaitPage;

public class M03DunamicTest extends BaseTest {
    P03DynamicWaitPage dynamic;
    @Test
    public void validateDynamicWait(){
        dynamic = new P03DynamicWaitPage(drive);
        dynamic.checkDynamicLoading();
    }
}
