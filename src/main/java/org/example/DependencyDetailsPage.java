package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DependencyDetailsPage {

    private static final String BRANCH_BUTTON_XPATH = "//details[@id='branch-select-menu']/summary";
    private static final String BRANCH_DIV_XPATH = "//div[@class='SelectMenu-list']/a[@class='SelectMenu-item']/span[contains(@class, 'break-word')]";
    private static final String BRANCHES_CONTAINER_XPATH = "//div[@class='SelectMenu-modal']/tab-container/div[@id='ref-list-branches']";
    private static final String FILENAME_XPATH = "//div[@role='rowheader']/span/a";


    public void clickBranchButton() {
        $(byXpath(BRANCH_BUTTON_XPATH)).click();
    }

    public List<String> getBranches() {
        SelenideElement branchesContainer = $(byXpath(BRANCHES_CONTAINER_XPATH));
        branchesContainer.waitUntil(Condition.visible, 3000);
        List<String> branches = new ArrayList<>();
        List<SelenideElement> elements = $$(byXpath(BRANCH_DIV_XPATH));
        String branch;
        for (SelenideElement e : elements) {
            branch = e.getText();
            branches.add(branch);
        }
        return branches;
    }

    public List<String> getFilenames() {
        List<String> filenames = new ArrayList<>();
        List<SelenideElement> elements = $$(byXpath(FILENAME_XPATH));

        for (SelenideElement e : elements) {
            filenames.add(e.getText());
        }
        return filenames;
    }
}
