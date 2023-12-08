import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginLogout;
import pages.PersonalArea;

public class PersonalAreaTest {
    private static final String email = "dimplomtest@diplom.ru";
    private static final String pass = "1234567";
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода по клику на «Личный кабинет»")
    public void jumpToPersonalArea() {
        LoginLogout objLoginLogout = new LoginLogout(driver);
        PersonalArea objPersonalArea = new PersonalArea(driver);

        //вход по кнопке «Войти в аккаунт» на главной
        objLoginLogout.loginMainPage(email, pass);

        //ждем загрузки главной страницы (после успешной авторизации)
        objLoginLogout.waitForLoadMainPage();

        //клик по кнопке "личный кабинет"
        objLoginLogout.clickPersAreaButton();

        //ждем загрузки страницы Профиль
        objPersonalArea.waitForLoadProfilePage();

        //переменная в которой хранится финишный текст
        String finishText = objPersonalArea.profileText();

        Assert.assertEquals("Профиль", finishText);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверка перехода по клику на «Конструктор»")
    public void jumpToConstructor() {
        LoginLogout objLoginLogout = new LoginLogout(driver);
        objLoginLogout.loginMainPage(email, pass);

        //ждем загрузки главной страницы
        objLoginLogout.waitForLoadMainPage();

        PersonalArea objPersonalArea = new PersonalArea(driver);

        //клик по кнопке "личный кабинет"
        objLoginLogout.clickPersAreaButton();

        //ждем загрузки страницы Профиль
        objPersonalArea.waitForLoadProfilePage();

        //клик на ссылку «Конструктор»
        objPersonalArea.clickConstructor();

        String finishText = objLoginLogout.mainH1Text();
        Assert.assertEquals("Соберите бургер", finishText);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор - Stellar Burgers")
    @Description("Проверка перехода по клику на логотип Stellar Burgers.")
    public void jumpToLogo() {
        LoginLogout objLoginLogout = new LoginLogout(driver);
        objLoginLogout.loginMainPage(email, pass);

        //ждем загрузки главной страницы
        objLoginLogout.waitForLoadMainPage();

        PersonalArea objPersonalArea = new PersonalArea(driver);

        //клик по кнопке "личный кабинет"
        objLoginLogout.clickPersAreaButton();

        //ждем загрузки страницы Профиль
        objPersonalArea.waitForLoadProfilePage();

        //клик на логотип
        objPersonalArea.clickLogo();

        String finishText = objLoginLogout.mainH1Text();
        Assert.assertEquals("Соберите бургер", finishText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
