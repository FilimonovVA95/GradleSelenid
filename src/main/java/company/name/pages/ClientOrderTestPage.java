package company.name.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;

public class ClientOrderTestPage extends AbstractPage {


    private SelenideElement loginButton = $("#header-lk-button");                                                   // Открыть окно авторизации
    private SelenideElement loginFiled = $("#login");                                                               // Поле ввода email
    private SelenideElement passwordField = $("[type=password]");                                                   // Поле ввода пароля
    private SelenideElement submitButton = $("[ng-tr=\"WHE1.WHE4\"]");                                              // Кнопка авторизации
    private SelenideElement exitButton = $("#logout");                                                              // Кнопка выхода
    private SelenideElement createTest = $(".new_test");                                                            // Открыть окно создания нового теста
    private SelenideElement testNameField = $("[data-testid=\"Test name input\"]");                                 // Поле ввода названия теста
    private SelenideElement siteNameField = $("[data-testid=\"Address site input\"]");                              // Поле ввода тестируемого сайта
    private SelenideElement informationField = $("[data-testid=\"Information textarea\"]");                         // Поле ввода информации для респондента
    private SelenideElement toPeopleGroup = $("[data-testid=\"Submit button\"]");                                   // Кнопка перехода к выбору аудитории
    private SelenideElement segmentNameField = $("[data-testid=\"Segment name input 0\"]");                         // Поле для ввода названия сегмента
    private SelenideElement taskClick = $("[data-testid=\"Tasks button\"]");                                        // Кнопка перехода к заданиям
    private SelenideElement taskField = $("[data-testid=\"Tasks task question\"]");                                 // Поле для ввода вопросов
    private SelenideElement addTask = $("[data-testid=\"Tasks submit task\"]");                                     // Кнопка добавления задания
    private SelenideElement checkTaskAdd = $("[data-testid=\"Tasks task undefined\"]");                             // Проверка что задание появилось
    private SelenideElement checkAndRunButton = $("[data-testid=\"Check button\"]");                                // Кнопка перехода к проверке и запуску теста
    private SelenideElement runFreeTestButton = $("[data-testid=\"Checkout start button\"]");                       // Запуск бесплатного теста
    private SelenideElement testListClick = $(":nth-child(2).iaxSpn");                                              // Перейти к списку тестов
    private SelenideElement checkLastTestName =
            $("[class=\"MuiTable-root\"] [class=\"MuiTableBody-root\"] tr:first-child td:first-child a");           // Проверка имени последнего теста
    private SelenideElement deleteLastTest =
            $("[class=\"MuiTypography-root MuiLink-root MuiLink-underlineAlways sc-oTNDV ldMtUr MuiTypography-colorPrimary\"]");        // Закрытие последнего теста
    private SelenideElement yesDeleteButtonClick = $(".irdQhg");                                                                        // Подтвердить закрытие теста


    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public ClientOrderTestPage() {
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

    @Step("Войти в личный кабинет клиента")
    public void logIn(String  login, String password) {
        loginButton.click();
        loginFiled.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Выйти'", checkExitButton(), "Log In exception");
    }

    @Step("Нажать кнопку 'Выход'")
    public void logout() {
        exitButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Вход'", checkLoginButton(), "Logout exception");
    }

    @Step("Нажать кнопку 'Новый тест'")
    public void createTest() {
        createTest.click();
        checkAndScreenShot("Проверяем активность кнопки 'К выбору аудитории'", checkToPeopleGroup(), "Create test exception");
    }

    @Step("Ввести название теста")
    public void inputNameTest(String nameTest) {
        testNameField.sendKeys(nameTest);
        checkAndScreenShot("Проверяем правильность ввода в поле 'Название теста'", checkTestNameField(nameTest), "Input name test exception");
    }

    @Step("Ввести адрес тестируемого сайта")
    public void inputSiteTest(String siteTest) {
        siteNameField.sendKeys(siteTest);
        checkAndScreenShot("Проверяем правильность ввода в поле 'Адрес тестируемого сайта'",
                checkSiteNameField("https://" + siteTest), "Input site test exception");
    }

    @Step("Ввести вводную информацию")
    public void inputIntroductoryInformation(String information) {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        informationField.sendKeys(del);
        informationField.sendKeys(information);
        checkAndScreenShot("Проверяем правильность ввода в поле 'Вводная информация'",
                checkInformationField(information), "Input introductory information exception");
    }

    @Step("Нажать кнопку 'К выбору аудитории'")
    public void clickNext() {
        toPeopleGroup.click();
        checkAndScreenShot("Проверяем активность кнопки 'К заданиям'", checkTaskClick(), "Passing to audience exception");
    }

    @Step("Ввести название сегмента")
    public void inputSegmentName(String segmentName) {
        segmentNameField.sendKeys(segmentName);
        checkAndScreenShot("Проверяем правильность ввода в поле 'Название сегмента'",
                checkSegmentNameField(segmentName), "Input segment name exception");
    }

    @Step("Нажать кнопку 'К заданиям'")
    public void clickTasks() {
        taskClick.click();
        checkAndScreenShot("Проверяем активность кнопки 'Проверка и запуск'", checkAndRunButton(), "Passing to tasks exception");
    }

    @Step("Ввести вопросы")
    public void inputTask(String task) {
        taskField.sendKeys(task);
        checkAndScreenShot("Проверяем правильность ввода в поле 'Вопросы'", checkTaskField(task), "Input task exception");
    }

    @Step("Нажать кнопку 'Добавить'")
    public void clickAddTask() {
        addTask.click();
        checkAndScreenShot("Проверяем активность кнопки 'Удалить'", checkTaskAdd(), "Add task exception");
    }

    @Step("Нажать кнопку 'Проверка и запуск'")
    public void clickCheckAndRun() {
        checkAndRunButton.click();
        checkAndScreenShot("Проверяем активность кнопки 'Запустить бесплатный тест'", checkRunFreeTestButton(), "Check and run exception");
    }

    @Step("Нажать кнопку 'Запустить бесплатный тест'")
    public void clickRunFreeTest() {
        runFreeTestButton.click();
    }

    @Step("Нажать кнопку 'Вернуться к списку тестов'")
    public void clickGoToListTests(String nameTest) {
        testListClick.click();
        checkAndScreenShot("Проверяем наличие последнего теста", checkLastTestName(nameTest), "Test list exception");
    }

    @Step("Закрываем последний тест")
    public void closeTest() {
        checkLastTestName.click();
        deleteLastTest.click();
        yesDeleteButtonClick.click();
    }


    /**
     * проверка кнопки открытия PopUp
     * @return возвращает true если найден объект
     */
    public boolean checkLoginButton() {
        return loginButton.isEnabled();
    }

    /**
     * проверка кнопки выхода из личного кабинета
     * @return возвращает true если найден объект
     */
    public boolean checkExitButton() {
        return exitButton.isEnabled();
    }

    /**
     * проверка имени теста
     * @param name корректное имя пользователя
     * @return возвращает true если совпадает имя
     */
    public boolean checkTestNameField(String name) {
        return testNameField.getAttribute("value").equals(name);
    }

    /**
     * проверка введенной информации о тесте
     * @param information корректная информация
     * @return возвращает true если совпадает информация
     */
    public boolean checkInformationField(String information) {
        return informationField.getAttribute("value").equals(information);
    }

    /**
     * проверка ввода тестируемого сайта
     * @param site корректный сайт компании
     * @return возвращает true если совпадает сайт
     */
    public boolean checkSiteNameField(String site) {
        return siteNameField.getAttribute("value").equals(site);
    }

    /**
     * проверка активности кнопки 'К выбору аудитории'
     * @return возвращает true если найден объект
     */
    public boolean checkToPeopleGroup() {
        return toPeopleGroup.isEnabled();
    }

    /**
     * проверки введенного имени сегмента
     * @param segmentName корректное имя сегмента
     * @return возвращает true если совпадает имя сегмента
     */
    public boolean checkSegmentNameField(String segmentName) {
        return segmentNameField.getAttribute("value").equals(segmentName);
    }

    /**
     * проверка активности кнопки 'К задачам'
     * @return возвращает true если найден объект
     */
    public boolean checkTaskClick() {
        return taskClick.isEnabled();
    }

    /**
     * проверка введенного задания
     * @param task корректное задание
     * @return возвращает true если совпадает задание
     */
    public boolean checkTaskField(String task) {
        return taskField.getAttribute("value").equals(task);
    }

    /**
     * проверка добавления задачи
     * @return возвращает true если найден объект
     */
    public boolean checkTaskAdd() {
        return checkTaskAdd.isEnabled();
    }

    /**
     * проверка активности кнопки 'Проверка и запуск'
     * @return возвращает true если найден объект
     */
    public boolean checkAndRunButton() {
        return checkAndRunButton.isEnabled();
    }

    /**
     * проверка активности кнопки 'Запустить бесплатный тест'
     * @return возвращает true если найден объект
     */
    public boolean checkRunFreeTestButton() {
        return runFreeTestButton.isEnabled();
    }

    /**
     * проверка совпадения имени последенго теста в списке тестов с созданым тестом
     * @param nameTest имя созданного теста
     * @return возвращает true если совпадает имя последнего теста
     */
    public boolean checkLastTestName(String nameTest) {
        return checkLastTestName.getText().equals(nameTest);
    }

}
