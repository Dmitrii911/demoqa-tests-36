package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {
    @BeforeAll
    static void basicBrowserSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; // ускоренная загрузка страницы

    }

    @Tag("demoqa")
    @Test
    void successfulFillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/automation-practice-form");
        //Убираем рекламу
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        // Вводим данные в поля
        $("#userName-wrapper #firstName").setValue("Ivan");
        $("#userName-wrapper #lastName").setValue("Ivanov");
        $("#userEmail-wrapper #userEmail").setValue("Ivanov@ivan.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8965412365");
        // Устанавливаем дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1917");
        $(".react-datepicker__day--025").click();
        // Заполняем предмет изучения
        $("#subjectsInput").setValue("Maths").pressEnter();
        // Отмечаем хобби
        $("#hobbiesWrapper").$(byText("Reading")).click();
        // Загружаем файл
        $("#uploadPicture").uploadFromClasspath("file.txt");
        // Адрес
        $("#currentAddress").setValue("123 Main St.");
        // Штат и Город
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        // Отправляем форму
        $("#submit").click();
        // Проверяем, что каждый элемент отображён в модальном окне
        $(".table-responsive").shouldHave(text("Student Name Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("Student Email Ivanov@ivan.com"));
        $(".table-responsive").shouldHave(text("Gender Male"));
        $(".table-responsive").shouldHave(text("Mobile 8965412365"));
        $(".table-responsive").shouldHave(text("Date of Birth 25 November,1917"));
        $(".table-responsive").shouldHave(text("Subjects Maths"));
        $(".table-responsive").shouldHave(text("Hobbies Reading"));
        $(".table-responsive").shouldHave(text("Picture file.txt")); // Имя загруженного файла
        $(".table-responsive").shouldHave(text("Address 123 Main St."));
        $(".table-responsive").shouldHave(text("State and City NCR Delhi"));


        // Дополнительно проверяем общий успех отправки формы
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
    }
    }

