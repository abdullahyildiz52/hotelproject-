package tests.munir;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0004QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_TC0001 extends TestBaseRapor {

    // TC_0001_US_0004 Açılan pencerede Hotel Management->Hotel List tıklandığında "LIST OF HOTELS" sayfasına gelmeliyim


    @Test
    public void test1(){
        extentTest = extentReports.createTest("Siteye giriş ve login başarılı.");

        US_0004QAConcortPage us_0004QAConcortPage = new US_0004QAConcortPage();
        us_0004QAConcortPage.ConcortHotelLogin();
        extentTest.info("Siteye gidildi ve giriş yapıldı");

        ReusableMethods.waitFor(5);
        us_0004QAConcortPage.hotelManagement.click();
        us_0004QAConcortPage.hotelList.click();
        extentTest.info("Sırasıyla Hotel Management, Hotel list butonları tıklandı.");

        Assert.assertTrue(us_0004QAConcortPage.listOfHotels.isDisplayed());
        extentTest.pass("List of Hotels sayfası görüldü.");


        Driver.closeDriver();



    }
}
