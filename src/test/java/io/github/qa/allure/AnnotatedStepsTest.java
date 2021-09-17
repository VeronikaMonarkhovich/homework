package io.github.qa.allure;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {
    private final static String REPOSITORY = "allure-notifications";
    private final static String ISSUE_NAME = "Add launch user name";

    @Test
    public void testGithub(){
        WebSteps step = new WebSteps();
        step.openMainPage();
        step.searchForRepository(REPOSITORY);
        step.goToRepository(REPOSITORY);
        step.openIssuesTab();
        step.shouldHaveName(ISSUE_NAME);
    }
}
