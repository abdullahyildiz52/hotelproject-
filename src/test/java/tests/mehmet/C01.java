package tests.mehmet;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01 {




    @Test
    public void test1(){

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        Driver.closeDriver();
    }
}
