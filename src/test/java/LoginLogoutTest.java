import jdk.jfr.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginLogout;
import Pages.PersonalArea;

public class LoginLogoutTest {
    private static final String email = "dimplomtest@diplom.ru";
    private static final String pass = "1234567";
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Вход - кнопка «Войти в аккаунт»")
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginMainPage() {
        LoginLogout objLoginLogout = new LoginLogout(driver);
        objLoginLogout.loginMainPage(email, pass);

        //ждем загрузки главной страницы
        objLoginLogout.waitForLoadMainPage();

        String finishText = objLoginLogout.mainH1Text();
        Assert.assertEquals("Соберите бургер", finishText);
    }

    @Test
    @DisplayName("Вход - кнопка «Личный кабинет»")
    @Description("Вход через кнопку «Личный кабинет»")
    public void loginPersonalArea() {
        LoginLogout objLoginLogout = new LoginLogout(driver);
        objLoginLogout.loginPersonalArea(email, pass);

        //ждем загрузки главной страницы
        objLoginLogout.waitForLoadMainPage();

        String finishText = objLoginLogout.mainH1Text();
        Assert.assertEquals("Соберите бургер", finishText);
    }

    @Test
    @DisplayName("Вход - через форму регистрации")
    @Description("Вход через кнопку в форме регистрации")
    public void loginRegister() {
        LoginLogout objLoginLogout = new LoginLogout(driver);
        objLoginLogout.loginRegister(email, pass);

        //ждем загрузки главной страницы
        objLoginLogout.waitForLoadMainPage();

        String finishText = objLoginLogout.mainH1Text();
        Assert.assertEquals("Соберите бургер", finishText);
    }

    @Test
    @DisplayName("Вход - через восстановления пароля")
    @Description("вход через кнопку в форме восстановления пароля")
    public void loginResetPass() {
        LoginLogout objLoginLogout = new LoginLogout(driver);
        objLoginLogout.loginResetPass(email, pass);

        //ждем загрузки главной страницы
        objLoginLogout.waitForLoadMainPage();

        String finishText = objLoginLogout.mainH1Text();
        Assert.assertEquals("Соберите бургер", finishText);
    }

    @Test
    @DisplayName("Выход")
    @Description("Проверь выход по кнопке «Выйти» в личном кабинете.")
    public void logout() {
        LoginLogout objLoginLogout = new LoginLogout(driver);
        objLoginLogout.loginMainPage(email, pass);

        //ждем загрузки главной страницы
        objLoginLogout.waitForLoadMainPage();

        PersonalArea objPersonalArea = new PersonalArea(driver);

        //клик по кнопке "личный кабинет"
        objLoginLogout.clickPersAreaButton();

        //ждем загрузки страницы Профиль
        objPersonalArea.waitForLoadProfilePage();

        //клик по кнопке "Выход"
        objLoginLogout.clickLogoutLink();

        //ждем загрузки страницы Вход
        objLoginLogout.waitForLoadLoginPage();

        String finishText = objLoginLogout.loginText();
        Assert.assertEquals("Вход", finishText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
