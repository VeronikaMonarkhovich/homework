package io.github.qa.allure;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    private final static String REPOSITORY = "allure-notifications";
    private final static String ISSUE_NAME = "Add launch user name";

    @Test
    public void testGithub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        } );

        step("Ищем репзиторий" + REPOSITORY , () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY );
            $(".header-search-input").submit();
        } );

        step("Переходим в репозиторий", () -> {
            $(linkText(REPOSITORY)).click();
        } );

        step("Открываем раздел Issues", () -> {
            $(partialLinkText("Issues")).click();
        } );

        step("Проверяем название Issue", () -> {
            $("#issue_65_link").shouldHave(text(ISSUE_NAME));
        } );

    }
}
