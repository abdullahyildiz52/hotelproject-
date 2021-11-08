package tests.melike;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_0002_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0002_TC_0003 extends TestBaseRapor {

    @Test
    public void test3 () {
    US_0002_QAConcortPage US2QaPage = new US_0002_QAConcortPage();
    SoftAssert softAssert = new SoftAssert();

    //1- Bir yönetici olarak otelin anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
    //2- Sağ üstteki "log in" butonuna tıklayın.
        US2QaPage.firstlogIn.click();
    //3- Login sayfasına gidin.
        US2QaPage.ConcortHotelLogin();
        Driver.getDriver().navigate().back();
        US2QaPage.ucuncuLOgIn.click();
    //4- Sayfada yer alan "User Menu" nun görülebilir olduğunu test edin
        Assert.assertTrue(US2QaPage.userMenu.isDisplayed(),"User Menu görülebilir değil");

    //5- User Menu altında "Reservations" öğesinin görülebilir olduğunu test edin
        Assert.assertTrue(US2QaPage.reservations.isDisplayed(),"reservations öğesi görülebilir değil");
    //6- User Menu altında "Profile" öğesinin görülebilir ve tıklanabilir olduğunu test edin
        Assert.assertTrue(US2QaPage.profile.isDisplayed(),"profile öğesi görülebilir değil");
    //7- User Menu altında "Change Password" öğesinin görülebilir ve tıklanabilir olduğunu test edin
        Assert.assertTrue(US2QaPage.changePassword.isDisplayed(),"Change Password öğesi görülebilir değil");
        softAssert.assertAll();
        extentTest=extentReports.createTest("Login sayfasi User Menu görülebilir testi");
        Driver.closeDriver();
    }
}
