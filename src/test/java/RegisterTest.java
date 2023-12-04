import jdk.jfr.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Register;

public class RegisterTest {
    private static final String name = "Кирилл";
    private static final String email = "email";
    private static final String pass = "123456";
    private static final String badPass = "12345";
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @DisplayName("Регистрация - успех")
    @Description("Успешная регистрация")
    public void goodRegisterTest() {
        int num = Register.rndNum();
        Register objRegister = new Register(driver);
        objRegister.register(name, email + num + "@domain.ru", pass);

        //ждем загрузки страницы /login
        objRegister.waitForLoadLoginPage();

        String finishText = objRegister.getGoodFinishText();
        Assert.assertEquals("Регистрация не успешна! - Такой пользователь уже существует", "Вход", finishText);
    }

    @Test
    @DisplayName("Регистрация - длина пароля")
    @Description("Ошибка некорректного пароля. Минимальный пароль — шесть символов.")
    public void badRegisterTest() {
        Register objRegister = new Register(driver);
        objRegister.register(name, email, badPass);

        String finishText = objRegister.getBadFinishText();
        Assert.assertEquals("Некорректный пароль", finishText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
