package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;
import utils.DriverFactory;

/**
 * Created by Igor Odokienko
 */
public class SmartphonesTvElectronicPage extends BasePage {

    @FindBy(linkText = "Телефоны")
    public WebElement phonesLink;

    @Step
    public void goToPhonesPage() {

        DriverFactory.getWait().
                until(ExpectedConditions.elementToBeClickable(phonesLink))
                .click();
    }

}
