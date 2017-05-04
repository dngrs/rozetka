package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;
import utils.DriverFactory;

/**
 * Created by Igor Odokienko
 */
public class PhonesPage extends BasePage {

    @FindBy(linkText = "Смартфоны")
    WebElement smatrphonesLink;

    @Step
    public void goToSmartphonesPage() {

        DriverFactory.getWait().
                until(ExpectedConditions.elementToBeClickable(smatrphonesLink)).
                click();
    }

}
