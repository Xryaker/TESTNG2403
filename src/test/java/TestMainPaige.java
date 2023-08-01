import config.BaseClass;
import data.DataTest;
import liseners.MainPageLisener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;
@Listeners(MainPageLisener.class)
public class TestMainPaige extends BaseClass {
    static final String MAIN_URL="https://dnipro.ithillel.ua/";
    MainPage page;
    @BeforeClass
    public void bb(){
        driver.get(MAIN_URL);
        page= new MainPage(driver);
    }
    @Test(testName = "Search TEst",dataProviderClass = DataTest.class,dataProvider = "getSearchVariant")
    public void testQuery(String courseName, List<String> listResponse) throws InterruptedException {
        Assert.assertEquals(page.chekResponseList(courseName),listResponse);
    }
}
