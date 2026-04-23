import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {REPOSITORY}")
    public void searchForRepository(String REPOSITORY) {
        $(".search-input-container").click();
        $("#query-builder-test").setValue(REPOSITORY).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {REPOSITORY}")
    public void clickOnRepositoryLink(String REPOSITORY) {
        $(By.linkText(REPOSITORY)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {ISSUE}")
    public void shouldSeeIssueWithNumber (int ISSUE) {
        $(withText("#" + ISSUE)).should(Condition.exist);
    }
}
