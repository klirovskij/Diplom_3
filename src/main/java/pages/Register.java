package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Register {

    private final WebDriver driver;
    //Заголовок h1 главной страницы
    private final By mainH1 = By.xpath("//h1[text()='Соберите бургер']");
    //кнопка "Личный кабинет"
    private final By personalAreaButton = By.xpath("//p[text()='Личный Кабинет']");
    //Ссылка "Зарегистрироваться"
    private final By regLink = By.linkText("Зарегистрироваться");
    //Поле "имя"
    private final By regName = By.xpath("//input[@name='name']");
    //Поле "E-mail"
    private final By regEmail = By.xpath("(//input[@name='name'])[2]");
    //Поле "Пароль"
    private final By regPass = By.xpath("//input[@type='password']");
    //Кнопка зарегистрироваться
    private final By regButton = By.xpath("//button[text()='Зарегистрироваться']");
    //goodtext при регистрации, если регистрация успешна
    private final By regGoodText = By.xpath("//h2[text()='Вход']");
    //badtext при регистрации, если такой пользователь уже зарегистрирован
    private final By regBadText = By.xpath("//p[text()='Некорректный пароль']");

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    //рандом для уникального email при регистрации
    public static int rndNum() {
        Random random = new Random();
        return 3600 + random.nextInt(1000000 - 3600);
    }

    //метод ожидания загрузки главной страницы
    public void waitForLoadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(mainH1));
    }

    //метод ожидания загрузки страницы Вход
    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(regGoodText));
    }

    //метод клика по кнопке "Личный кабинет"
    public void clickButtonPersonalArea() {
        driver.findElement(personalAreaButton).click();
    }

    //метод клика по кнопке "Личный кабинет"
    public void clickButtonRegLink() {
        driver.findElement(regLink).click();
    }

    //метод заполняет поля «Имя»
    public void setRegName(String name) {
        driver.findElement(regName).sendKeys(name);
    }

    //метод заполняет поля «email»
    public void setRegEmail(String email) {
        driver.findElement(regEmail).sendKeys(email);
    }

    //метод заполняет поля «Пароль»
    public void setRegPass(String pass) {
        driver.findElement(regPass).sendKeys(pass);
    }

    //метод клика по кнопке "зарегистрироваться"
    public void clickButtonRegButton() {
        driver.findElement(regButton).click();
    }

    public void register(String name, String email, String pass) {
        waitForLoadMainPage();
        clickButtonPersonalArea();
        clickButtonRegLink();
        setRegName(name);
        setRegEmail(email);
        setRegPass(pass);
        clickButtonRegButton();
    }

    public String getGoodFinishText() {
        return driver.findElement(regGoodText).getText();
    }

    public String getBadFinishText() {
        return driver.findElement(regBadText).getText();
    }
}