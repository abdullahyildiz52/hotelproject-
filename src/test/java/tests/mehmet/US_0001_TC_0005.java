package tests.mehmet;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US0001QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_0001_TC_0005 extends TestBaseRapor {

    //Anasayfaki "Our Rooms" yazısının görülmesi


    US0001QAConcortPage us0001QAConcortPage = new US0001QAConcortPage();
    ReusableMethods reusableMethods = new ReusableMethods();

    @Test
    public void test1() throws InterruptedException {
        ReusableMethods.waitForPageToLoad(3000);
        //1-Kullanıcı "CONCORT OTEL" sayfasına gider.
        extentTest = extentReports.createTest("Siteye geçerli URL ile giriş testi");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        //2-Kullanıcı scroll yaparak sayfayı kaydırır.
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,1500)");
        extentTest=extentReports.createTest("scrool down testi");
        //3-"Our Rooms" yazısını görür.
        Thread.sleep(2000);
        Assert.assertTrue(us0001QAConcortPage.ourRoomsYaziElementi.isDisplayed(),"our room yazisi gözükmüyor");
    extentTest=extentReports.createTest("our rooms görünür testi.");
    }
}