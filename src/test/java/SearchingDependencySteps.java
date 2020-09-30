import com.codeborne.selenide.Configuration;
import io.cucumber.java8.En;
import org.example.DependencyDetailsPage;
import org.example.FileManager;
import org.example.HomePage;
import org.example.ResultPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class SearchingDependencySteps implements En {

    private ResultPage resultPage;
    private DependencyDetailsPage dependencyDetailsPage;
    private final String pathName = "branches";
    private final String names = "filenames";


    public SearchingDependencySteps() {
        Configuration.startMaximized = true;

        Given("User opens page", () -> {
            open("https://github.com/");
        });

        Given("User inputs {string} dependency name and clicks Enter", (String dependency) -> {
            new HomePage().inputDependency(dependency);
        });

        Given("User selects {string} language", (String language) -> {
            resultPage = new ResultPage();
            resultPage.selectLanguage(language);
        });

        Given("User selects first dependency", () -> {
            resultPage.clickFirstResult();
        });

        Given("User clicks Branch dropdown", () -> {
            dependencyDetailsPage = new DependencyDetailsPage();
            dependencyDetailsPage.clickBranchButton();
        });

        When("User saves visible branches", () -> {
            List<String> branches = dependencyDetailsPage.getBranches();
            FileManager.saveTextToFile(branches, pathName);
        });

        When("User saves all folders and filenames", () -> {
            List<String> filenames = dependencyDetailsPage.getFilenames();
            FileManager.saveTextToFile(filenames, names);
        });

        Then("Branches and folders and filenames are saved", () -> {

        });

    }
}
