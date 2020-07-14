package company.name.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Класс страницы для проверки меню главной страницы
 * @author Филимонов Виктор
 */
public class StartPage extends AbstractPage {

    private SelenideElement loginButton = $("#header-lk-button");                                       // кнопка открытия окна авторизации
    private SelenideElement aboutProductionButton  = $(".nl-header-link[ng-tr=\"NLHEA.NLHEA1\"]");      // кнопка перейти на страницу "О продукте"
    private SelenideElement priceButton  = $(".nl-header-link[ng-tr=\"NLHEA.NLHEA2\"]");                // кнопка перейти на страницу "Цены"
    private SelenideElement faqButton  = $(".nl-header-link[ng-tr=\"NLHEA.NLHEA3\"]");                  // кнопка перейти на страницу "FAQ"
    private SelenideElement wantTestSitesButton  = $(".nl-header-link[ng-tr=\"NLHEA.NLHEA4\"]");        // кнопка перейти на страницу "Хочу тестировать сайты"
    private SelenideElement checkAboutProduction  = $("[ng-tr=\"NLABO.NLABO1\"]");                      // проверка наличия элемента на странице "О продукте"
    private SelenideElement checkPrice  = $("[ng-tr=\"NLPRC.NLPRC1\"]");                                // проверка наличия элемента на странице "Цены"
    private SelenideElement checkFAQ  = $(".nl-faq-header");                                            // проверка наличия элемента на странице "FAQ"
    private SelenideElement checkWantTestSite  = $("[ng-tr=\"NLTES.NLTES6\"]");                         // проверка наличия элемента на странице "Хочу стать тестировщиком"


    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public StartPage() {
        super();
    }

    @Step("Открыть тестовый стенд")
    public void openTestStand() {
        Selenide.open(getStand());
        checkAndScreenShot("Проверяем активность кнопки 'Войти'",
                checkLoginButton(), "Open test stand exception");
    }

    @Step("Открыть предПрод стенд")
    public void openPreprodStand() {
        Selenide.open(getStand());
        checkAndScreenShot("Проверяем активность кнопки 'Войти'",
                checkLoginButton(), "Open test stand exception");
    }

    @Step("Нажать кнопку 'О продукте'")
    public void openAboutProductionButton() {
        aboutProductionButton.click();
        checkAndScreenShot("Проверяем открытие страницы 'О продукте'",
                checkAboutProduction(), "Open about production page exception");
    }

    @Step("Нажать кнопку 'Цены'")
    public void openPrice() {
        priceButton.click();
        checkAndScreenShot("Проверяем открытие страницы 'Цены'",
                checkPrice(), "Open price page exception");
    }

    @Step("Нажать кнопку 'FAQ'")
    public void openFAQ() {
        faqButton.click();
        checkAndScreenShot("Проверяем открытие страницы 'FAQ'",
                checkFAQ(), "Open FAQ page exception");
    }

    @Step("Нажать кнопку 'Хочу стать тестировщиком'")
    public void openWantTestSites() {
        wantTestSitesButton.click();
        checkAndScreenShot("Проверяем открытие страницы 'Хочу стать тестировщиком'",
                checkWantTestSite(), "Open want test sites page exception");
    }

    /**
     * проверка активности кнопки "Войти"
     * @return true, если элемент найден
     */
    private boolean checkLoginButton() {
        return loginButton.isEnabled();
    }

    /**
     * проверка наличия элемента на странице "О продукте"
     * @return true, если элемент найден
     */
    private boolean checkAboutProduction() {
        return checkAboutProduction.isEnabled();
    }

    /**
     * проверка наличия элемента на странице "Цены"
     * @return true, если элемент найден
     */
    private boolean checkPrice() {
        return checkPrice.isEnabled();
    }

    /**
     * проверка наличия элемента на странице "FAQ"
     * @return true, если элемент найден
     */
    private boolean checkFAQ() {
        return checkFAQ.isEnabled();
    }

    /**
     * проверка наличия элемента на странице "Хочу стать тестировщиком"
     * @return true, если элемент найден
     */
    private boolean checkWantTestSite() {
        return checkWantTestSite.isEnabled();
    }



}
