package pages;

import utils.DriverFactory;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Igor Odokienko
 */
public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
}
