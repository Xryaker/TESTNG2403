package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    @FindBy(xpath = "//button[@data-dropdown-trigger=\"coursesMenu\"]")
    WebElement courseButton;
    @FindBy(xpath = "//div[@id=\"coursesMenuSearchField\"]//input[@class=\"search-field_input\"]")
    WebElement searchField;
    @FindBy(xpath = "//div[@data-id=\"result\"]//p[@class=\"course-label_name\"]")
    List<WebElement> responseList;



    @Step("Query string : {query}")
    public List<String> chekResponseList(String query) throws InterruptedException {
        if (!searchField.isDisplayed()) {
            courseButton.click();
        }
        searchField.clear();
        searchField.sendKeys(query);
        Thread.sleep(3000);
        List<String> list = new ArrayList<>();
        for (WebElement l : responseList) {
            list.add(l.getText());
        }
        Allure.addAttachment("My responce", list.toString());
        return list;
    }
}
