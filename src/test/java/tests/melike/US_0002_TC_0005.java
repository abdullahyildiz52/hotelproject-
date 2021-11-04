package tests.melike;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US0002QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0002_TC_0005 {

    @Test
    public void test5 () {
        US0002QAConcortPage US2QaPage = new US0002QAConcortPage();
        SoftAssert softAssert = new SoftAssert();
        //1- Bir yönetici olarak otelin anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        //2- Sağ üstte yer alan "log in" butonuna tıklayın.
        US2QaPage.firstlogIn.click();
        //3- Açılan pencerede yer alan username textbox'ına geçerli olmayan bir "username" girin.
        US2QaPage.userName.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        //4- Açılan pencerede yer alan password textbox'ına geçerli olmayan bir "password" girin.
        US2QaPage.password.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        US2QaPage.secondLogIn.click();

        //5-Sayfanın URL'inin "https://qa-environment.concorthotel.com/Admin/UserAdmin" olmadığını doğrulayın
        String expectedURL = ConfigReader.getProperty("CHQAManagerPageURL");
        String actualURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertFalse(actualURL.equals(expectedURL),"Geçersiz kullanıcı adı ve password ile giriş başarılı TEST FAILED");
        //6-Sayfada hata mesajının görülebilir olduğunu test edin
        Assert.assertTrue(US2QaPage.hataMesaji.isDisplayed(),"Hata mesajı görüntülenemiyor");

        Driver.closeDriver();



    }
}
