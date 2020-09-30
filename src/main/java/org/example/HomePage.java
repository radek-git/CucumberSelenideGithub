package org.example;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public void inputDependency(String dependency) {
        $(byName("q")).val(dependency).pressEnter();
    }
}
