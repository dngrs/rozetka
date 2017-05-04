import Db.Queries;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.PhonesPage;
import pages.SmartphonesPage;
import pages.SmartphonesTvElectronicPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import utils.DbConnector;
import utils.PropertyConfig;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by Igor Odokienko
 */
@Features("Check catalogue")
@Stories("Check top-sale items in Smartphones catalogue")
public class TopSaleSmartphonesTest extends BaseTest {

    @Before
    public void prepareTestEnvironment() {

        Connection con = DbConnector.initConnection();
        Statement st = DbConnector.getStatement(con);
        Queries.executeClearTable(st);
        DbConnector.closeConnection(con, st);

        File testFile = new File(PropertyConfig.getProperty("testFile"));
        System.out.println(PropertyConfig.getProperty("testFile"));
        if (testFile.exists()) {
            System.out.println(testFile.exists());
            System.out.println(testFile.getAbsolutePath());
            testFile.delete();
        }

    }

    @Test
    public void test() {

        HomePage homePage = new HomePage();
        SmartphonesTvElectronicPage smartphonesTvElectronicPage = new SmartphonesTvElectronicPage();
        PhonesPage phonesPage = new PhonesPage();
        SmartphonesPage smartphonesPage = new SmartphonesPage();

        homePage.openMainPage();
        homePage.goToSmartphonesTvElectronicPage();
        smartphonesTvElectronicPage.goToPhonesPage();
        phonesPage.goToSmartphonesPage();

        Connection con = DbConnector.initConnection();
        Statement st = DbConnector.getStatement(con);
        Queries.executeSaveProductsToDb(smartphonesPage.getPhoneTitleAndPriceList(1), st);
        Queries.saveReportToFile(st);
        DbConnector.closeConnection(con, st);
        Assert.assertTrue(new File(PropertyConfig.getProperty("testFile")).exists());
    }

}
