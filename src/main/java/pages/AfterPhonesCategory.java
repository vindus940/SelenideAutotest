package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class AfterPhonesCategory {

    private List<String> findResults;

    @Step("Устанавливаем 12 элементов на страницу{SetQuantity}")
    public AfterPhonesCategory dropDownClick() {

        SelenideElement ClickDropBox1 = $x("//div[contains(@data-tid, '1c7202ea')]");
        ClickDropBox1.click();
        SelenideElement ClickDropBox2 = $x("//button[contains(@data-tid, '65f9fd17')]");
        ClickDropBox2.click();

        return this;
    }

    public List<String> collectResultsFromPage() throws InterruptedException {

        $x("//div[@class='_8v6CF']").waitUntil(visible, 4000);

        List<SelenideElement> resultsNameWebElement = $$x("//article//h3[@data-zone-name = 'title']//span");

       Assertions.assertTrue(resultsNameWebElement.stream().anyMatch(x->x.getText().contains("Apple")),
               "the snippet does not contain the name of the apple");

        return resultsNameWebElement.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }

    private boolean initNextPageButton() {

        List<SelenideElement> goNextPageButton = $$x("//a[contains(@class, '_3OFYT')]");
        if(goNextPageButton.size() > 0){
            goNextPageButton.get(0).click();
            return true;
        }
        else
            return false;
    }

    public AfterPhonesCategory collectResults() throws InterruptedException {
        findResults = collectResultsFromPage();
        while (initNextPageButton()) {
            findResults.addAll(collectResultsFromPage());
        }
        return this;
    }
}
