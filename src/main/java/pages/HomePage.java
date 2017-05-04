package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;
import utils.DriverFactory;
import utils.PropertyConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor Odokienko
 */
public class HomePage extends BasePage {

    public static final String BASE_URL = PropertyConfig.getProperty("baseUrl");
    @FindBy(linkText = "Смартфоны, ТВ и электроника")
    WebElement smartphonesTvElectronicLink;

    @Step
    public HomePage openMainPage() {
        DriverFactory.getDriver().get(BASE_URL);
        return new HomePage();
    }

    @Step
    public void goToSmartphonesTvElectronicPage() {
        DriverFactory.getWait().
                until(ExpectedConditions.elementToBeClickable(smartphonesTvElectronicLink)).
                click();
    }

}
