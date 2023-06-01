package testPackage;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class WikiTest3 {
    @Test
      void checkParagraph(){
        // открываем ссылку
       open("https://en.wikipedia.org/wiki/Java_(programming_language)");
       // проверяем каждый параграф
       elements("[id^='p-']").shouldHave(sizeGreaterThan(0));
    }
}
