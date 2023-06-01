package testPackage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class WikiTest5v4 {
    @Test
    void changeLanguageV4(){
        // открываем ссылку
        open("https://wikipedia.org/wiki/Java");
        // ищем по id нужный нам элемент
        SelenideElement languageSwitcher = Selenide.$(By.id("p-lang-btn-checkbox"));
        // Кликаем чтобы открыть лист с языками
        languageSwitcher.click();
        //указываем xpath нужного языка
        element(By.xpath("/html/body/div[1]/div[2]/div[1]/div/ul/li[3]/a")).click();
    }
}
