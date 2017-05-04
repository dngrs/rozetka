package Db;

import pages.UIelements.CatalogItem;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import utils.PropertyConfig;

import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Igor Odokienko
 */
public class Queries {

    public static void executeClearTable(Statement st) {
        try {
            st.executeUpdate("DELETE FROM smartphones");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Step
    public static void executeSaveProductsToDb(List<CatalogItem> listOfItems, Statement st) {
        for (CatalogItem item : listOfItems) {
            try {
                st.executeUpdate("insert into rozetka.smartphones (MODEL, PRICE) values ('"+item.getTitle()+"', "+item.getPrice()+")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Step
    public static void saveReportToFile(Statement st) {
        try {

            st.executeQuery("SELECT \n" +
                    "    'MODEL', 'PRICE'\n" +
                    "UNION ALL\n" +
                    "SELECT MODEL, PRICE\n" +
                    "FROM\n" +
                    "    smartphones\n" +
                    "INTO OUTFILE '/tmp/data/report.csv' \n" +
                    "\n" +
                    "FIELDS ENCLOSED BY '\"'\n" +
                    "TERMINATED BY ',' \n" +
                    "LINES TERMINATED BY '\\r\\n';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        attachFileToReport("report");
    }

    @Attachment(value = "{0}", type = "text/csv")
    public static File attachFileToReport (String file) {
        return new File(PropertyConfig.getProperty("testFile"));
    }

}
