package testGmailPackage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;

public class Log {
    @Test
    @Order(1)
    public void testLoginToGmail() {
        // Логин на gmail.com
        open("https://mail.google.com");
        $(By.name("identifier")).setValue("gtest4220@gmail.com").pressEnter();
        sleep(5000);
        $(By.name("password")).setValue("testpasstest").pressEnter();
        // Проверка успешного входа
        $(By.id("gbq1")).should(appear);
    }
}
