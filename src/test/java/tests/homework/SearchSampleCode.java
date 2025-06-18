package tests.homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSampleCode {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";

    }

    @Test
    void SearchSampleCodeTest () {
        //   Открыть страницу Selenide в Github
        open("/selenide/selenide");
        //  Перейти в раздел Wiki проекта
        $("#wiki-tab").$(byText("Wiki")).click();
        // Проверить, что в списке страниц (Pages) есть страница SoftAssertions
        $("[data-filterable-for=wiki-pages-filter]").$(".wiki-more-pages-link").$("button").click();
        $("[data-filterable-for=wiki-pages-filter]")
                .shouldHave(text("SoftAssertions"));
        // Открыть страницу SoftAssertions
        $("[data-filterable-for=wiki-pages-filter]")
                .$(byText("SoftAssertions")).click();
        // Проверить что внутри есть пример кода для JUnit5
        $(".gollum-markdown-content")
                .shouldHave(text("Using JUnit5 extend test class:"),

              text("@ExtendWith({SoftAssertsExtension.class})"));

    }
}
