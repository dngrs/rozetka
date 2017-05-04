import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import utils.DriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Created by Igor Odokienko
 */
public class BaseTest {

    @BeforeClass
    public static void setUp() {
        DriverFactory.init();
    }

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure("Screenshot on failure");
        }
    };

    @AfterClass
    public static void tearDown() {
        DriverFactory.close();
    }

    @Attachment(value = "{0}", type = "image/png")
    private byte[] makeScreenshotOnFailure(String attachName) {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
