package company.name.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;

/**
 * Класс страницы для авторизации клиента
 */
public class AuthenticationPage extends AbstractPage {

    private SelenideElement loginButton = $("#header-lk-button");                      // кнопка открытия окна авторизации
    private SelenideElement loginFiled = $("#login");                                  // поле для ввода логина при входе
    private SelenideElement passwordField = $("[type=password]");                      // поле для ввода пароля
    private SelenideElement clickLogIn = $("[ng-tr=\"WHE1.WHE4\"]");                   // Кнопка войти в аккаунт
    private SelenideElement clickLogOut = $("#logout");                                // Кнопка выйти

    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public AuthenticationPage() {
        super();
    }

    @Step("Открыть тестовый стенд")
    public void openTestStand() {
        Selenide.open(getStand());
        checkAndScreenShot("Проверяем активность кнопки 'Войти'",
                checkLoginButton(), "Open test stand exception");
    }

    @Step("Нажать кнопку 'Войти'")
    public void openPopUp() {
        loginButton.click();
        checkAndScreenShot("Проверяем открытие окна авторизации",
                checkClickLogIn(), "Open popUp exception");
    }

    @Step("Ввести e-mail")
    public void inputEmail (String email) {
        loginFiled.sendKeys(email);
        checkAndScreenShot("Проверяем правильность ввода email",
                checkLoginField(email), "Input email authorization exception");
    }

    @Step("Ввести пароль")
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
        checkAndScreenShot("Проверяем правильность ввода пароля",
                checkPasswordField(password), "Input password authorization exception");
    }

    @Step("Нажать кнопку войти")
    public void clickAuthentication(){
        clickLogIn.click();
        checkAndScreenShot("Проверяем активность кнопки 'Выйти'",
                checkClickLogOut(), "Client login exception");
    }

    @Step("Нажать кнопку выйти")
    public void logOut(){
        clickLogOut.click();
        checkAndScreenShot("Проверяем активность кнопки 'Войти'",
                checkLoginButton(), "Client LogOut exception");
    }

    /**
     * Проверяем активность кнопки "Войти"
     * @return true, если элемент найден
     */
    private boolean checkLoginButton() {
        return loginButton.isEnabled();
    }

    /**
     * Проверяем, что email коррентно введен
     * @param email введеный email
     * @return true, если элемент найден
     */
    private boolean checkLoginField(String email) {
        return loginFiled.getAttribute("value").equals(email);
    }

    /**
     * Проверяем, что пароль коррентно введен
     * @param password введеный пароль
     * @return true, если элемент найден
     */
    private boolean checkPasswordField(String password) {
        return passwordField.getAttribute("value").equals(password);
    }

    /**
     * Проверяем наличие кнопки "Войти"
     * @return true, если элемент найден
     */
    private boolean checkClickLogIn() {
        return clickLogIn.isEnabled();
    }

    /**
     * Проверяем наличие кнопки "Выйти"
     * @return true, если элемент найден
     */
    private boolean checkClickLogOut() {
        return clickLogOut.isEnabled();
    }

}
