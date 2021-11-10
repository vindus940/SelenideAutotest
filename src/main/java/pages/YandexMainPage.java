package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class YandexMainPage  extends BaseTest  {

    @Step("Ищу слово {query}")
    public YandexSearchResult search(String query) {
        $(By.name("text")).setValue(query).pressEnter();
        return page(YandexSearchResult.class);
    }
}
