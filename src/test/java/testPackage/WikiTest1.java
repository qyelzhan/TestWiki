package testPackage;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class WikiTest1 {
    @Test
    void checkSearch(){
        //открываем ссылку
        open("https://www.wikipedia.org/");
        // ищем статью
        element(byName("search")).setValue("Java").pressEnter();
        // проверяем совпадает ли поиск с результатом
        $("#firstHeading").shouldHave(Condition.text("Java"));

    }
}
