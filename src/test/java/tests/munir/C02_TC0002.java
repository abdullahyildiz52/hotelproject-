package tests.munir;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0004QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_TC0002 extends TestBaseRapor {

    // TC_0002_US_0004 Add hotel butonuna tıklandığında
    // create hotel sayfasına gidebilmeliyim, otel ekleyebilmeliyim (PT)

    @Test
    public void test2() {
        extentTest = extentReports.createTest("Siteye giriş ve otel ekleme (PT).");

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
                .sendKeys(ConfigReader.getProperty("Codebox"))
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
        extentTest.info("Tüm textbox'lar sırasıyla dolduruldu");

        us_0004QAConcortPage.saveButonu.click();
        extentTest.info("Save butonuna tıklandı");

        ReusableMethods.waitFor(2);
        Assert.assertTrue(us_0004QAConcortPage.succesfullyYazisi.isDisplayed());

        us_0004QAConcortPage.okButonu.click();
        extentTest.pass("Otel başarıyla eklendi");

        Driver.closeDriver();


    }
}
