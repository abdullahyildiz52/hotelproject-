package tests.mehmet;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US0001QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_0001_TC_0006 extends TestBaseRapor {

    //Anasayfaki Footer Menü'sü öğelerinin görülmesi


    US0001QAConcortPage us0001QAConcortPage = new US0001QAConcortPage();
    ReusableMethods reusableMethods = new ReusableMethods();

    @Test
    public void test1() throws InterruptedException {
        ReusableMethods.waitForPageToLoad(3000);
        //1-Kullanıcı "CONCORT OTEL" sayfasına gider.
        extentTest = extentReports.createTest("Siteye geçerli URL ile giriş testi");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        //2-Kullanıcı scrooll yaparak sayfanın en altına gelir.
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,5000)");
        extentTest=extentReports.createTest("scrooldown testi");
        Thread.sleep(2000);
        //3-"Footer menüsü"'nü görür.
        Assert.assertTrue(us0001QAConcortPage.footerMenu.isDisplayed(),"footer menu görünür degil");
        extentTest=extentReports.createTest("footer menu görünür testi");
        //4-"Useful Links"yazisini görür.
        Assert.assertTrue(us0001QAConcortPage.usefulYaziElementi.isDisplayed(),"useful Links görünür değil");
        extentTest=extentReports.createTest("useful link görünür testi");
        //5-"Have a Questions?"adres panosunu görür.
        Assert.assertTrue(us0001QAConcortPage.haveAQuestions.isDisplayed(),"Have A Question Panosu görünür değil");
        extentTest=extentReports.createTest("Have A Questions Panosu görünür testi");

    }
}

