package data;

import org.testng.annotations.DataProvider;

public class DataTest {
    @DataProvider
    public static Object[][] getNames(){
        return new Object[][]{
                {"Vasiliy"},
                {"Ivan"},
                {"Oleg"}
        };
    }
}
