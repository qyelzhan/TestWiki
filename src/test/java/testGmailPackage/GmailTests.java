package testGmailPackage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GmailTests {
    // определяем часто используемые  элементы чтобы не повторяться
    SelenideElement SentMessagesBtn = $(byCssSelector("div[class='TN bzz aHS-bnu']"));
   // SelenideElement ComposeBtn =$(By.xpath("//body/div[7]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));
    SelenideElement ComposeBtn =$(byCssSelector("div[style='user-select: none']"));
    SelenideElement SendBtn =$(byCssSelector("div[data-tooltip-delay='800']"));
    //SelenideElement SaveChangesBtn =$(byCssSelector("div[role='navigation']"));
    SelenideElement SaveChangesBtn =$(byXpath("/html[1]/body[1]/div[7]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[33]/td[1]/div[1]/button[1]"));
    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome"; // выбираем браузер
        Configuration.pageLoadTimeout = Long.parseLong("300");// ожидание загрузки страницы
        Configuration.browserSize = "600x600";// окно браузера
        Configuration.timeout = 300000;// ожидание загрузки веб элементов
    }
    @Test
    public void gmailTestRunner(){
        loginToGmail();
        testSendEmail();
        testAddSignature();
        sendMessageWithSingature();
        checkSentEmailWithSignature();
    }
    //@Test @Order(1)
    public void loginToGmail() {
        open("https://gmail.com");// открываем джимейл
        //в поле инпут имейла вводим наш имейл
        $("#identifierId").setValue("gtest4220@gmail.com").pressEnter();
        WaitOneSec();
        //в поле пароля вводим наш пароль
        $(byCssSelector("[type='password']")).setValue("testpasstest").pressEnter();
        $("#gb").should(exist);//проверяем что мы успешно зашли
        WaitOneSec();
    }
    //@Test @Order(2)
    public void testSendEmail() {
        checkLogining();// проверяем зашли ли мы в джимейл
       ComposeBtn.click(); // нажимаем на кнопку написать
       MessageFiller("qyelzhan@gmail.com","Test email","text text text text text");
       SendBtn.click();// нажимаем отправить
       WaitOneSec();// на всякий ждем секнуду
       testCheckSentEmail();// проверяем отправленное сообщение путем вызова метода
    }
    public void testCheckSentEmail(){
        SentMessagesBtn.click();// захожим в "отправленные"
        $(By.xpath("//div[span='Test email']")).should(Condition.exist);// ищем наше сообщение
        WaitOneSec();
    }
    //@Test @Order(3)
    public void testAddSignature(){
        checkLogining();
        $(byCssSelector("a[class='FH']")).click();// нажимаем настройки
        $(byCssSelector("button[class='Tj']")).click();// все настройки
        $(byCssSelector("button[class='P5']")).click();//создать подпись
        $(byCssSelector("input[class='xx nr']")).setValue("Test signature");// название подписи
        $(byName("ok")).click();// нажимаем ок чтобы сохранить название

        String signatureMessage = "best wishes Name Surname";
        $(byCssSelector("div[role='textbox']")).setValue(signatureMessage);// контент нашей подписи
        SaveChangesBtn.click();// сохраняем изменения
        WaitOneSec();
    }
   // @Test @Order(4)
    public void sendMessageWithSingature(){
        ComposeBtn.click();
        MessageFiller("qyelzhan@gmail.com","Test email","dskj");
        $(byCssSelector("div[class='BP aaA aMZ']")).click();// нажимаем на подписи
        $(byText("Test signature")).click(); // выбираем нужную
        SendBtn.click();// отправляем сообщение
        WaitOneSec();
    }
    //@Test @Order(5)
    public void checkSentEmailWithSignature(){
        SentMessagesBtn.click();// заходим в отправленные
        $(By.xpath("//div[span='Test email']")).should(Condition.exist);// проверяем письмо
        WaitOneSec();
    }
    public void MessageFiller(String email, String subject, String textContent){
        $(byCssSelector("[role='combobox']")).setValue(email);// вводим емэйл адресата
        $(byCssSelector("[name='subjectbox']")).setValue(subject);// Тема сообщения
        $(byCssSelector("div[role='textbox']")).setValue(textContent);// основное сообщение
        WaitOneSec();
    }
    public void checkLogining(){
        if($("#identifierId").exists()){ loginToGmail();}
        else {}
    }
    public void WaitOneSec(){ sleep(1000); }

}
