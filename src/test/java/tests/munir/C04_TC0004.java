package tests.munir;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0004_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C04_TC0004 extends TestBaseRapor {

    // TC_0004_US_0004 Add hotel sayfasındaki Box'ların doldurulabilmesi (NT 2)

    @Test
    public void test4(){
        extentTest = extentReports.createTest("Siteye giriş ve otel ekleme (NT 2).");

        US_0004_QAConcortPage us_0004QAConcortPage = new US_0004_QAConcortPage();
        us_0004QAConcortPage.ConcortHotelLogin();
        extentTest.info("Siteye gidildi ve giriş yapıldı");

        ReusableMethods.waitFor(2);
        us_0004QAConcortPage.hotelManagement.click();
        us_0004QAConcortPage.hotelList.click();
        us_0004QAConcortPage.addHotelButonu.click();
        extentTest.info("Sırasıyla Hotel Management, Hotel list butonları tıklandı.");

        Actions actions = new Actions(Driver.getDriver());


        actions.click(us_0004QAConcortPage.codeTextBox)
                .sendKeys(ConfigReader.getProperty("Codebox"))
                .sendKeys(Keys.TAB)
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
        extentTest.info("Name textbox'ı hariç tüm textbox'lar sırasıyla dolduruldu");

        us_0004QAConcortPage.saveButonu.click();
        extentTest.info("Save butonuna tıklandı");

        Assert.assertTrue(us_0004QAConcortPage.nameError.isDisplayed());
        extentTest.pass("Name textbox'ı girilmediğinde otel eklenmedi ve 'Name' yazısı görüldü");

        Driver.closeDriver();
    }
}
