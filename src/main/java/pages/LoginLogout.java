package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginLogout {

    private final WebDriver driver;
    //Заголовок h1 главной страницы
    private final By mainH1 = By.xpath("//h1[text()='Соберите бургер']");
    //«Войти в аккаунт» на главной
    private final By mainloginButton = By.xpath("//button[text()='Войти в аккаунт']");
    //кнопка "Личный кабинет"
    private final By personalAreaButton = By.xpath("//p[text()='Личный Кабинет']");
    //Ссылка "Зарегистрироваться"
    private final By textRegLink = By.linkText("Зарегистрироваться");
    //Ссылка "Войти"
    private final By textLoginLink = By.linkText("Войти");
    //Ссылка "Восстановить пароль"
    private final By textResetPass = By.linkText("Восстановить пароль");
    private final By loginEmail = By.xpath("//input[@type='text']");
    private final By loginPass = By.xpath("//input[@type='password']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By logoutButton = By.xpath("//button[text()='Выход']");
    private final By textLogin = By.xpath("//h2[text()='Вход']");

    public LoginLogout(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания загрузки главной страницы
    public void waitForLoadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(mainH1));
    }

    //метод ожидания загрузки страницы Вход
    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(textLogin));
    }

    //метод клика по кнопке "Войти в аккаунт"
    public void clickMainLoginButton() {
        driver.findElement(mainloginButton).click();
    }

    //метод клика по кнопке "Личный кабинет"
    public void clickPersAreaButton() {
        driver.findElement(personalAreaButton).click();
    }

    //метод клика по кнопке "Зарегистрироваться"
    public void clickRegLinkButton() {
        driver.findElement(textRegLink).click();
    }

    //метод клика по кнопке "Войти"
    public void clickLoginLink() {
        driver.findElement(textLoginLink).click();
    }

    //метод клика по кнопке "Восстановить пароль"
    public void clickResetPass() {
        driver.findElement(textResetPass).click();
    }

    //метод заполняет поля «email»
    public void setRegEmail(String email) {
        driver.findElement(loginEmail).sendKeys(email);
    }

    //метод заполняет поля «Пароль»
    public void setRegPass(String pass) {
        driver.findElement(loginPass).sendKeys(pass);
    }

    //метод клика по кнопке на форме входа
    public void clickButtonLogin() {
        driver.findElement(loginButton).click();
    }

    public String mainH1Text() {
        return driver.findElement(mainH1).getText();
    }

    //метод клика по кнопке "Выйти"
    public void clickLogoutLink() {
        driver.findElement(logoutButton).click();
    }

    public String loginText() {
        return driver.findElement(textLogin).getText();
    }

    //Заполнение формы входа
    public void fillOutTheForm(String email, String pass) {
        setRegEmail(email);
        setRegPass(pass);
        clickButtonLogin();
    }

    //вход по кнопке «Войти в аккаунт» на главной
    public void loginMainPage(String email, String pass) {
        waitForLoadMainPage();
        clickMainLoginButton();
        fillOutTheForm(email, pass);
    }

    //вход через кнопку «Личный кабинет»
    public void loginPersonalArea(String email, String pass) {
        waitForLoadMainPage();
        clickPersAreaButton();
        fillOutTheForm(email, pass);
    }

    //вход через кнопку в форме регистрации
    public void loginRegister(String email, String pass) {
        waitForLoadMainPage();
        clickPersAreaButton();
        clickRegLinkButton();
        clickLoginLink();
        fillOutTheForm(email, pass);
    }

    //вход через кнопку в форме восстановления пароля
    public void loginResetPass(String email, String pass) {
        waitForLoadMainPage();
        clickPersAreaButton();
        clickResetPass();
        clickLoginLink();
        fillOutTheForm(email, pass);
    }
}
