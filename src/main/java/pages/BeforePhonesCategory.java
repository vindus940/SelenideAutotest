package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class BeforePhonesCategory  extends BaseTest  {

    @Step("Переходим в категорию телефоны {goCategory}")
    public BeforePhonesCategory categoryGo(){

        SelenideElement goCat = $x("//a[@href='/catalog--elektronika/54440']");
        goCat.click();
        switchTo().window(1);

        SelenideElement goCat2 = $x("//a[@href='/catalog--mobilnye-telefony/26893750/list?hid=91491']");
        goCat2.click();
        switchTo().window(1);

        return this;
    }
    @Step("Выбираем производителя и проверяем выборку {selected}")
    public BeforePhonesCategory selectProduct() {
        SelenideElement clickToPhone = $x("//label[@for='7893318_153043']");
        clickToPhone.click();
        return this;
    }
}
