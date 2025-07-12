package tests.wb;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тесты на WB")
@Tag("SMOKE")
public class WbParametrizedTests {

    @BeforeEach
    void setUp() {
        open("https://www.wildberries.ru/");
    }
    @ValueSource(strings = {
            "часы мужские наручные", "часы женские наручные"
    })

    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой список карточек")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE")
    })
    void successfulSearchTest(String searchQuery) {
        $(".search-catalog__input").setValue(searchQuery).pressEnter();
        $$(".j-card-item").shouldBe(CollectionCondition.sizeGreaterThan(0));

    }

    ;
    @CsvFileSource(resources ="/searchResultQueryCheckCsvFileTest.csv")

    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой список карточек c количеством {1}")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE")
    })
    void SearchResultQueryCheckCsvFileTest(String searchQuery, String amount) {
        $(".search-catalog__input").setValue(searchQuery).pressEnter();
        $$(".j-card-item").shouldBe(CollectionCondition.sizeGreaterThan(0));
        $(".searching-results__title").shouldHave(text(searchQuery));
        $(".searching-results__count").shouldHave(text(amount));

    }

    ;

    @CsvSource(value = {
            "часы мужские наручные, 99 011",
            "часы женские наручные, 68 353"
    })

    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой список карточек c количеством {1}")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE")
    })
    void SearchResultQueryCheckTest(String searchQuery, String amount) {
        $(".search-catalog__input").setValue(searchQuery).pressEnter();
        $$(".j-card-item").shouldBe(CollectionCondition.sizeGreaterThan(0));
        $(".searching-results__title").shouldHave(text(searchQuery));
        $(".searching-results__count").shouldHave(text(amount));

    };


    static Stream<Arguments> costDependsOnCurrency(){
        return Stream.of(
                Arguments.of(tests.wb.Currency.RUB, "Российский рубль"),
                Arguments.of(tests.wb.Currency.BYN,  "Белорусский рубль"),
                Arguments.of(tests.wb.Currency.KZT,  "Казахстанский тенге"),
                Arguments.of(tests.wb.Currency.AMD,  "Армянский драм"),
                Arguments.of(tests.wb.Currency.KGS,  "Кыргызский сом"),
                Arguments.of(tests.wb.Currency.UZS,  "Узбекский сум"),
                Arguments.of(tests.wb.Currency.TJS,  "Таджикский сомони")
        );
    }

    //@Disabled
    @MethodSource()
    @Tags({@Tag("Blocker"), @Tag("UI_TEST")})
    @ParameterizedTest (name = "Валюта {0} на сайте WB это {1}")
    void costDependsOnCurrency(tests.wb.Currency currency, @NonNull String description){
        open ("https://www.wildberries.ru");
        $(".simple-menu__link--country").hover();
        $(".simple-menu__tooltip")
                .$$(".radio-with-text__text")
                .filterBy(Condition.text(currency.name()))
                .first()
                .shouldHave(Condition.text(description));
    };

}
