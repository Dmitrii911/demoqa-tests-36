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
    void cursorHoverCheck() {
        open("https://github.com");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $(byText("Enterprises")).click();
        $("#hero-section-brand-heading")
                .shouldHave(text("The AI-powered\n" +
                "developer platform"));
    }

@Test
    void dragAndDropWithActions() {
    // Открытие страницы
    open("https://the-internet.herokuapp.com/drag_and_drop");

    // Нахождение элементов для перетаскивания
    SelenideElement columnA = $("#column-a");
    SelenideElement columnB = $("#column-b");

    // Перетаскивание элемента
    Actions actions = new Actions(WebDriverRunner.getWebDriver());
    actions.moveToElement(columnA).clickAndHold().moveToElement(columnB)
            .release()
            .perform();
    // actions.dragAndDrop(columnA, columnB).perform(); // Используем метод dragAndDrop()

    // Проверка результата перетаскивания
    columnB.shouldHave(text("A"));
    columnA.shouldHave(text("B"));

}
}



