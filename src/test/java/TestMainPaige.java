import config.BaseClass;
import data.DataTest;
import io.qameta.allure.*;
import liseners.MainPageLisener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;
import util.ScreenShoT;

import java.util.List;
@Listeners(MainPageLisener.class)
@Feature("MAIN feature")
public class TestMainPaige extends BaseClass {
    static final String MAIN_URL="https://dnipro.ithillel.ua/";
    MainPage page;
    @BeforeClass
    public void bb(){
        driver.get(MAIN_URL);
        page= PageFactory.initElements(driver,MainPage.class);
    }

    @Link(name = "VIDOSIK",type = "vasiliy")
    @Issue("#_junit_4")
    @TmsLink("#_testng")
    @Story("Base support for bdd annotations")
    @Test(description = "Test search result",testName = "Search TEst",dataProviderClass = DataTest.class,dataProvider = "getSearchVariant")
    public void testQuery(String courseName, List<String> listResponse) throws InterruptedException {
       // ScreenShoT.getScreenShot("screen");
        Assert.assertEquals(page.chekResponseList(courseName),listResponse);
    }

}
