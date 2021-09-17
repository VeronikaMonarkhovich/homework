package io.github.qa.allure;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    public void testGithub() {
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("allure-notifications");
        $(".header-search-input").submit();
        $(linkText("allure-notifications")).click();
        $(partialLinkText("Issues")).click();
        $("#issue_65_link").shouldHave(text("Add launch user name"));
    }

}