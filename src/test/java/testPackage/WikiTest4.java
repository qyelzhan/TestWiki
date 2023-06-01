package testPackage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Iterator;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class WikiTest4 {
    @Test
    void checkContent(){
        // открываем ссылку
        open("https://en.wikipedia.org/wiki/Java_(programming_language)");
        // находим содержание статьи
        SelenideElement articleContent = Selenide.$(By.id("content"));
        // Проверяем, что элемент с содержимым статьи имеет текст и видемость
        articleContent.shouldHave(exist).shouldHave(visible);
    }
}
