import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FindJUnitInSelenidePage {


    @BeforeAll
    static void beforAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
        //ARRANGE
    void fillFormTest() {
        open("/selenide/selenide");

        //ACT
        $("#wiki-tab").click();

        //ASSERT
        $(byTagAndText("a", "Soft assertions")).shouldBe(visible);

        //ACT
        $(byTagAndText("a", "Soft assertions")).click();

        //ASSERT
        $("#user-content-3-using-junit5-extend-test-class")
                .closest("h4").sibling(0).shouldHave(text("""
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                         @Test
                        void test() {
                        Configuration.assertionMode = SOFT;
                        open("page.html");

                        $("#first").should(visible).click();
                        $("#second").should(visible).click();
                        }
                        }"""));
    }
}


