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
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://github.com/"
        ;
    }
    @Test
    void shouldFindeSelenideRepositoreAtTheTop(){

        // Откройте страницу Selenide в Github
        open("/selenide/selenide");

        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$("a[class='internal present']").findBy(text("Soft assertions")).shouldBe(visible);

        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$("a[class='internal present']").findBy(text("Soft assertions")).click();


        $$(".heading-element").findBy(text("Mechanisms:")).shouldBe(visible);
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("Using JUnit5"));
        $$("h4[class='heading-element']").findBy(text("3. Using JUnit5 extend test class:")).shouldBe(visible);

      //  Configuration.holdBrowserOpen=true;
    }
}

