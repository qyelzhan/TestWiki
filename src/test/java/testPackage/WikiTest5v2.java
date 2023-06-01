package testPackage;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class WikiTest5v2 {
    @Test
    void checkLanguageV2(){

        //open link
        open("https://www.wikipedia.org/");
        element(byName("search")).setValue("Kazakhstan").pressEnter();
        element("#p-lang > div > ul > li.interlanguage-link.interwiki-de.mw-list-item > a > span").click();
    }
}
