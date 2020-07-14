package company.name.positive;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import company.name.ClientRate;
import company.name.character.FreeClient;
import company.name.pages.ClientOrderTestPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTestFromClientTest {

    private ClientOrderTestPage step = new ClientOrderTestPage();
    private FreeClient user = new FreeClient();

    private String nameTest = "Name";
    private String siteTest = "test.uxcrowd.ru/";
    private String information = "Information";
    private String segmentName = "SegmentName";
    private String task = "Task";

    @BeforeMethod
    public void start(){
        Configuration.startMaximized = true;
    }

    @Test
    public void OrderTestFromClientTest() {

        if (user.rate != ClientRate.FREE) {
            System.out.println("Client rate exception");
            Selenide.closeWebDriver();
        }

        step.openTestStand();
        step.logIn(user.email, user.password);

        step.createTest();
        step.inputNameTest(nameTest);
        step.inputSiteTest(siteTest);
        step.inputIntroductoryInformation(information);
        step.clickNext();
        step.inputSegmentName(segmentName);
        step.clickTasks();
        step.inputTask(task);
        step.clickAddTask();
        step.clickCheckAndRun();
        step.clickRunFreeTest();
        step.clickGoToListTests(nameTest);
        step.closeTest();
        step.logout();

    }

}
