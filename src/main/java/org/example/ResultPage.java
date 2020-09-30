package org.example;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ResultPage {

    private static final String JAVA_LANGUAGE_XPATH = "(//ul/li/a[@class='filter-item'])[1]";
    private static final String FIRST_RESULT_XPATH = "//ul[@class='repo-list']/li/div[@class='mt-n1']/div/a";

    public void selectLanguage(String language) {
        $(byXpath("//ul/li/a[text()[normalize-space(.)='" + language + "']]"))
                .waitUntil(Condition.appear, 2000).click();
    }

    public void clickFirstResult() {
        $(byXpath(FIRST_RESULT_XPATH)).click();
    }
}
