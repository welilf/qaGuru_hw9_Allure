import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LabelsTest {

public final String repository =  "welilf/qaGuru_hw9_Allure";
public final int issue = 1;



    @Test
    public void cleanSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".search-input-container").click();
        $("#query-builder-test").setValue(repository).pressEnter();
        $(By.linkText(repository)).click();
        $("#issues-tab").click();
        $(withText("#" + issue)).should(Condition.exist);
    }

    @Test
    public void lambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + repository, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue(repository).pressEnter();
        });
        step("Кликаем по ссылке репозитория " + repository, () -> {
            $(By.linkText(repository)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + issue, () -> {
            $(withText("#" + issue)).should(Condition.exist);
        });
    }

    @Test
    public void annotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.clickOnRepositoryLink(repository);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(issue);
    }
}
