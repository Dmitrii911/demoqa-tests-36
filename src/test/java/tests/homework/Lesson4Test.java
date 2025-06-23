package tests.homework;

import com.codeborne.selenide.SelenideElement;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson4Test {
    @Test
    void cursorHoverCheckTest() {
        open("https://github.com");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $(byText("Enterprises")).click();
        $("#hero-section-brand-heading")
                .shouldHave(text("The AI-powered\n" +
                "developer platform"));
    }

@Test
    void ActionsTest() {

    // Открытие страницы
    open("https://the-internet.herokuapp.com/drag_and_drop");

    //Проверка начального состояния элементов
    $("#column-a").shouldHave(text("A"));
    $("#column-b").shouldHave(text("B"));

    // Нахождение элементов для перетаскивания
    SelenideElement columnA = $("#column-a");
    SelenideElement columnB = $("#column-b");

    // Перетаскивание элемента
    Actions actions = new Actions(WebDriverRunner.getWebDriver());
    actions.moveToElement(columnA).clickAndHold().moveToElement(columnB)
            .release()
            .perform();

    // Проверка результата перетаскивания
    columnB.shouldHave(text("A"));
    columnA.shouldHave(text("B"));

}
    @Test
    void dragAndDropWithActionsTest() {

        // Открытие страницы
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Проверка начального состояния элементов
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        // Нахождение элементов для перетаскивания
        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");

        // Перетаскивание элемента
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.dragAndDrop(columnA, columnB).perform(); // Используем метод dragAndDrop()

        // Проверка результата перетаскивания
        columnB.shouldHave(text("A"));
        columnA.shouldHave(text("B"));

    }
}



