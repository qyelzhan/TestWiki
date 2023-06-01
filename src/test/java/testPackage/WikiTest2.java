package testPackage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class WikiTest2 {
    @Test
    void checkMainPage(){
        //открываем ссылку
        open("https://www.wikipedia.org/");
        // ищем статью
        element(byName("search")).setValue("Java").pressEnter();
        // проверяем ссылку на заглавную страницу
        $("#n-mainpage-description > a > span").shouldHave(exist).shouldHave(visible).click();
    }

}
