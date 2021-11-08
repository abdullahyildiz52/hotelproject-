package tests.mehmet;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0001_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_0001_TC_0004 extends TestBaseRapor {

    //Anasayfaki "Check-in Menusunden"uygun kriterdeki oteller listelenmeli.(NEGATİVE)


    US_0001_QAConcortPage us0001QAConcortPage = new US_0001_QAConcortPage();
    ReusableMethods reusableMethods = new ReusableMethods();

    @Test
    public void test1() throws InterruptedException {
        ReusableMethods.waitForPageToLoad(3000);
        //1-Kullanıcı "CONCORT OTEL" sayfasına gider.
        extentTest = extentReports.createTest("Siteye geçerli URL ile giriş testi");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        // 2-Kullanıcı Anasayfadaki "Booking-Form" meüsünü görür.

        Assert.assertTrue(us0001QAConcortPage.bookingForm.isDisplayed(),"BookingForm görünür değil");
        extentTest=extentReports.createTest("bookingForm görünür testi");
        //3-Uygun zaman aralıklarını girer
        Actions actions=new Actions(Driver.getDriver());

        actions.doubleClick(us0001QAConcortPage.checkinDate).doubleClick().perform();
        String checkinTarih="11/3/2020";
        us0001QAConcortPage.checkinDate.sendKeys(checkinTarih);
        extentTest=extentReports.createTest("checkin tarih girme testi");
        String checkoutTarih="12/31/2020";
        actions.doubleClick(us0001QAConcortPage.checkoutDate).doubleClick().perform();
        us0001QAConcortPage.checkoutDate.sendKeys(checkoutTarih);
        extentTest=extentReports.createTest("checkout tarih giris testi");
        //4-Check Availability butonuna tıklar.
        us0001QAConcortPage.checkAvailabilityButon.click();
        extentTest=extentReports.createTest("checkAvailblty buton click testi");
        //5-Rooms sayfasını görüntüler.
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Concort Hotel - Rooms"),"Rooms sayfası görüntülenmiyor");
        extentTest=extentReports.createTest("secilen tarihler UYGUN OLMAMASINA RAĞMEN sıralama yapıldı");


    }
}