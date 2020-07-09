package company.name.positive;

import com.codeborne.selenide.Configuration;
import company.name.pages.StartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StartPageTest {

    private StartPage step = new StartPage();

    @BeforeMethod
    public void start(){
        Configuration.startMaximized = true;
    }

    @Test
    public void StartPage() {
        step.openTestStand();
        step.openAboutProductionButton();
        step.openPrice();
        step.openFAQ();
        step.openWantTestSites();
    }

}
