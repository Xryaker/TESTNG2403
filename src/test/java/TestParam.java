import data.DataTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParam {
    @DataProvider
    public static Object[][] getNames(){
        return new Object[][]{
                {"Vasiliy"},
                {"Ivan"},
                {"Oleg"}
        };
    }
    @Test(dataProvider = "getNames")
    public void test1(String name){
        System.out.println(name);
    }

    @Test(testName = "supertest",dataProvider = "getNames",dataProviderClass = DataTest.class)
    public void test2(String name){
        System.out.println(name);
    }
}
