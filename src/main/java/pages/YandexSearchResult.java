package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class YandexSearchResult  extends BaseTest  {

    @Step("Переходим по имени ссылки {linkName}")
    public <T extends BaseTest > T goLink (Class<T> typeNextPage){
        SelenideElement goSite = $x("//div[contains(@class, 'organic ') and contains(@class, 'bno')]");
        goSite.$x(".//a[@href]").click();
        switchTo().window(1);
        return typeNextPage.cast(page(typeNextPage));
    }
}
