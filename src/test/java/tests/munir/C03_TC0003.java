package tests.munir;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0004QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_TC0003 extends TestBaseRapor {

    // TC_0003_US_0004 Add hotel sayfasındaki Box'ların doldurulabilmesi (NT 1)

    @Test
    public void test3(){
        extentTest = extentReports.createTest("Siteye giriş ve otel ekleme (NT 1).");

        US_0004QAConcortPage us_0004QAConcortPage = new US_0004QAConcortPage();
        us_0004QAConcortPage.ConcortHotelLogin();
        extentTest.info("Siteye gidildi ve giriş yapıldı");

        ReusableMethods.waitFor(2);
        us_0004QAConcortPage.hotelManagement.click();
        us_0004QAConcortPage.hotelList.click();
        us_0004QAConcortPage.addHotelButonu.click();
        extentTest.info("Sırasıyla Hotel Management, Hotel list butonları tıklandı.");

        Actions actions = new Actions(Driver.getDriver());


        actions.click(us_0004QAConcortPage.codeTextBox)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("Namebox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("Addressbox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("Phonebox"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("Emailbox"))
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
        extentTest.info("Code textbox'ı hariç tüm textbox'lar sırasıyla dolduruldu");

        us_0004QAConcortPage.saveButonu.click();
        extentTest.info("Save butonuna tıklandı");

        Assert.assertTrue(us_0004QAConcortPage.codeError.isDisplayed());
        extentTest.pass("Code textbox'ı girilmediğinde otel eklenmedi ve 'Code' yazısı görüldü");

        Driver.closeDriver();
    }
}
