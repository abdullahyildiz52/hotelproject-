package tests.melike;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US0002QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0002_TC_0001 extends TestBaseRapor {



    @Test
    public void test1(){

        US0002QAConcortPage US2QaPage = new US0002QAConcortPage();

        //1- Bir yönetici olarak otelin anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        //2-Sol üstteki "CONCORT OTEL" yazısının görülebilir olduğunu test edin
        Assert.assertTrue(US2QaPage.ConcortHotelYazisi.isDisplayed(),"CONCORTHOTEL yazısı görünmüyor test failed");
        //3- URL'in "https://qa-environment.concorthotel.com/" olduğunu doğrulayın
        SoftAssert softAssert = new SoftAssert();
        String expectedURL = ConfigReader.getProperty("CHQAUrl");
        String actualURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualURL,expectedURL,"Sayfa URL'i beklenen URL ile aynı değil");

        //4- Sayfanın sağ üst kısmında yer alan Login butonunun görülebilir olduğunu test edin.
        Assert.assertTrue(US2QaPage.firstlogIn.isDisplayed(),"İlk Login butonu görünmüyor");
        //5- Login butonuna tıklayın.
        US2QaPage.firstlogIn.click();
        //6- Login sayfasının açıldığını test edin.
        String expectedURLLOginPage = ConfigReader.getProperty("CHQALoginPageURL");
        String actualURLLoginPage = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualURLLoginPage,expectedURLLOginPage,"Sayfa URL'i beklenen URL ile aynı değil");
        //7- Sayfada "Log in" ve "Create a new account" butonlarının görülebilir olduğunu test edin
        Assert.assertTrue(US2QaPage.secondLogIn.isDisplayed(),"Login butonu görüntülenemiyor");
        Assert.assertTrue(US2QaPage.CreateANewAccount.isDisplayed(),"Create a new account butonu görüntülenemiyor");
        //8-"Username" ve "Password" textboxlarının görebilir olduğunu test edin.
        Assert.assertTrue(US2QaPage.userName.isDisplayed(),"Username textbox'ı görüntülenemiyor");
        Assert.assertTrue(US2QaPage.password.isDisplayed());
        softAssert.assertAll();
        extentTest=extentReports.createTest("Login sayfasi textbox'ının görülebilir olduğunun testi");
        Driver.closeDriver();
    }
}
