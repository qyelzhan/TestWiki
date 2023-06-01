package testPackage.anotherTests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ToDoMvcTest {
    @Test
    void completesTask(){


        open("http://todomvc.com/examples/emberjs/");

        element("#new-todo").setValue("a").pressEnter();
        element("#new-todo").setValue("b").pressEnter();
        element("#new-todo").setValue("c").pressEnter();

        elements("#todo-list>li").shouldHave(exactTexts("a","b","c"));

       elements("#todo-list>li").findBy(exactText("b"))
                        .find(".toggle").click();
       elements("#todo-list>li").filterBy(cssClass("completed"))
                       .shouldHave(exactTexts("b"));

        elements("#todo-list>li").filterBy(not(cssClass("completed")))
                .shouldHave(exactTexts("a","c"));

    }
}
