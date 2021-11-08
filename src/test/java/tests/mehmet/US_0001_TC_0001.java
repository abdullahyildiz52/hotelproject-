package tests.mehmet;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import pages.US_0001_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0001_TC_0001 extends TestBaseRapor {


QAConcortPage qaConcortPage=new QAConcortPage();
US_0001_QAConcortPage us0001QAConcortPage=new US_0001_QAConcortPage();
    @Test
    public void test1(){

        extentTest=extentReports.createTest("Siteye geçerli URL ile giriş yapılabilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        String ActualURL="https://qa-environment.concorthotel.com/";
        String ExpectedURL=Driver.getDriver().getCurrentUrl();
       Assert.assertTrue(ActualURL.equals(ExpectedURL),"URL Beklendigi Gibi Degil");
       extentTest=extentReports.createTest("URL Testi Beklendiği Gibi");

       String ActualYaziElementi=us0001QAConcortPage.concortPageYaziElementi.getText();
       String ExpectedYaziElementi="CONCORT HOTEL";
       Assert.assertTrue(ActualYaziElementi.equals(ExpectedYaziElementi),"yazi elementi beklendiği gibi degil");
       extentTest=extentReports.createTest("Concort Hotel yazisi doğrulandı");

       Assert.assertTrue(us0001QAConcortPage.loginYaziElementi.isDisplayed(),"Log in görünür değil.");
       extentTest=extentReports.createTest("Log in butonu testi");



        Driver.closeDriver();
    }
}
