import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LabelsTest {

public final String repository =  "welilf/qaGuru_hw9_Allure";
public final int issue = 1;



    @Test
    void cleanSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".search-input-container").click();
        $("#query-builder-test").setValue(repository).pressEnter();
        $(By.linkText(repository)).click();
        $("#issues-tab").click();
        $(withText("#" + issue)).should(Condition.exist);
    }

    @Test
    void lambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @Test
    void annotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        

    }
}
