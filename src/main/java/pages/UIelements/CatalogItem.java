package pages.UIelements;

/**
 * Created by Igor Odokienko
 */
public class CatalogItem {

    private String title;
    private int price;

    public CatalogItem(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

}
