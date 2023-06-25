package testGmailPackage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GmailTests {
    @BeforeClass
    public static void setUp() {
        Configuration.browser = "chrome"; // Change to your preferred browser
    }

    @Test
    public void loginToGmail() {
        // открываем джимейл
        open("https://www.gmail.com");

        // определяем элементы чтобы легче было работать с ними
        SelenideElement emailInput = $("#identifierId");
        SelenideElement passwordInput = $("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input");


        SelenideElement nextButton = $("#identifierNext");
        SelenideElement nextButtonPass = $("#passwordNext > div > button");

        // в поле инпут имейла вводим наш имейл
        emailInput.setValue("gtest4220@gmail.com");
        nextButton.click();

        // в поле пароля вводим наш пароль
        passwordInput.setValue("testpasstest");
        nextButtonPass.click();
        sleep(5000);
       //  проверяем что мы успешно зашли
        $("#gb").should(exist);
    }
    @Test
    public void testSendEmail() {
        // Отправка письма с текстом
//        $(byCssSelector("body > div:nth-child(22) > div.nH > div > div.nH.aqk.aql.bkL > div.aeN.WR.baA.nH.oy8Mbf > div.aic > div > div")).click();
//        element(byName("to")).setValue("gmail");
//        sleep(5000);
        $(byText("Compose")).click();
        $(byName("to")).setValue("qyelzhan@gmail.com");
        $(byName("subjectbox")).setValue("Test email");
        $(byCssSelector("div[aria-label='Message Body']")).setValue("текст письма");
        $(byText("Send")).click();
    }
}
