package company.name.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.Assert;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import static com.codeborne.selenide.Selenide.screenshot;
import static io.qameta.allure.Allure.step;

/**
 * Абстрактный класс страницы. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
 */
public abstract class AbstractPage {
    /**
     * Поле страницы тест-стенда, загруженного с файла конфигурации
     */
    private static String testStand;
    private static String preprodStand;


    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public AbstractPage() {
        InputStream inputStream = AbstractPage.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException((e));
        }
        testStand = properties.getProperty("test.stand");
        preprodStand = properties.getProperty("preprod.stand");
    }

    public static String getStand() {
            return testStand;
        }

    public static String getPreprodStand() { return preprodStand; }

    protected void screenShotStep(String screenName) {
        String screenData = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String className = this.getClass().getSimpleName();
        String fullName = "." + File.separator + "target" + File.separator + "screen-shots" + File.separator + className + File.separator + screenData + "_Screenshot.png";
        byte[] screen = screenshot(fullName).getBytes();
        Allure.addAttachment(screenName + " " + screenData, new ByteArrayInputStream(screen));
    }

    protected void checkAndScreenShot (String nameStep, boolean check, String message) {
        screenShotStep(nameStep);
        step(nameStep, () -> {
            Assert.assertTrue(check, message);
        });

    }

    public abstract void openTestStand();

    public abstract void openPreprodStand();

}
