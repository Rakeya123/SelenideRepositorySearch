package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://github.com/"
        ;
    }
    @Test
    void shouldFindSelenideRepositoryAtTheTopTest(){

        // Откройте страницу Selenide в Github
        open("/selenide/selenide");

        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        //$$("a[class='internal present']").findBy(text("Soft assertions")).shouldBe(visible);
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();

        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
       // $$("a[class='internal present']").findBy(text("Soft assertions")).click();


        $$(".heading-element").findBy(text("Mechanisms:")).shouldBe(visible);
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("Using JUnit5"));
        $("#wiki-body").shouldHave(text("""
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
                @Test
                void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                }
            }""")).shouldBe(visible);
    }
      //  Configuration.holdBrowserOpen=true;
    }


