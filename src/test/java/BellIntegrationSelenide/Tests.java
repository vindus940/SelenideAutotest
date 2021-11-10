package BellIntegrationSelenide;

import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

public class Tests extends BaseTests {

    @Test
    public void yandexMarket() throws InterruptedException {
        open("https://yandex.ru/", YandexMainPage.class)
                .search("яндекс маркет")
                .goLink(BeforePhonesCategory.class)
                .categoryGo()
                .selectProduct();
        new AfterPhonesCategory()
                .dropDownClick()
                .collectResultsFromPage();
        new AfterPhonesCategory()
                .collectResults();
    }
}