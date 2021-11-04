package tests.munir;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0004QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C06_TC0006 extends TestBaseRapor {

    // TC_0006_US_0004 Kaydedilen hotel listede görünmeli

    @Test
    public void test6() {
        extentTest = extentReports.createTest("Siteye giriş ve kaydedilen otelin listede görülmesi.");

        US_0004QAConcortPage us_0004QAConcortPage = new US_0004QAConcortPage();
        us_0004QAConcortPage.ConcortHotelLogin();
        extentTest.info("Siteye gidildi ve giriş yapıldı");

        ReusableMethods.waitFor(2);
        us_0004QAConcortPage.hotelManagement.click();
        us_0004QAConcortPage.hotelList.click();
        extentTest.info("Sırasıyla Hotel Management, Hotel list butonları tıklandı.");

        us_0004QAConcortPage.hotelListCodeTextBox.sendKeys(ConfigReader.getProperty("Codebox"));
        extentTest.info("Code textbox'a geçerli kod girildi");

        us_0004QAConcortPage.searchButonu.click();
        extentTest.info("Search butonuna tıklandı.");

        Assert.assertTrue(us_0004QAConcortPage.codeHotelListesi.isDisplayed());
        extentTest.pass("Kaydedilen otel listede görüldü");

        Driver.closeDriver();


    }

}
