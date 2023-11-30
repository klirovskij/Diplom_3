package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalArea {
    private final WebDriver driver;
    //Текст Профиль
    private final By profileText = By.linkText("Профиль");
    //Текст Конструктор
    private final By constructorText = By.xpath("//p[text()='Конструктор']");
    //Логотип
    private final By logoText = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    public PersonalArea(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания загрузки страницы - Профиль
    public void waitForLoadProfilePage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
    }

    public String profileText() {
        return driver.findElement(profileText).getText();
    }

    public void clickConstructor() {
        driver.findElement(constructorText).click();
    }

    public void clickLogo() {
        driver.findElement(logoText).click();
    }

}
