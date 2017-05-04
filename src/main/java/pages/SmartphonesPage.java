package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.UIelements.CatalogItem;
import ru.yandex.qatools.allure.annotations.Step;
import utils.DriverFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor Odokienko
 */
public class SmartphonesPage extends BasePage {

    By topSaleItemTitleLocator = By.xpath("//i[contains(@class, 'popularity')]/following-sibling::a/img");
    By topSaleItemPriceLocator = By.xpath("//i[contains(@class,'popularity')]/../../..//div[@class='g-price-uah']");

    @Step
    public List<CatalogItem> getPhoneTitleAndPriceList(int pageCount) {
        List<CatalogItem> result = new ArrayList<>();

        for (int i = 1; i <= pageCount; i++) {
            List<WebElement> topSaleItemTitle = DriverFactory.getWait().
                    until(ExpectedConditions.visibilityOfAllElementsLocatedBy(topSaleItemTitleLocator));
            List<WebElement> topSaleItemPrice = DriverFactory.getWait().
                    until(ExpectedConditions.visibilityOfAllElementsLocatedBy(topSaleItemPriceLocator));

            Iterator<WebElement> titleIterator = topSaleItemTitle.iterator();
            Iterator<WebElement> priceIterator = topSaleItemPrice.iterator();

            while (titleIterator.hasNext()) {
                String title = titleIterator.next().getAttribute("title");
                System.out.println(title);
                int price = Integer.parseInt(priceIterator.next().getText().replaceAll("[^0-9]", ""));
                System.out.println(price);
                result.add(new CatalogItem(title, price));
            }
            if (i < pageCount) {
                WebElement paginator = DriverFactory.getWait().
                        until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='page" + (i + 1) + "']")));
                paginator.click();
            }
        }
        return result;
    }

}
