package tests.melike;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US0002QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0002_TC_0004 {

    @Test
    public void test4 () {
        US0002QAConcortPage US2QaPage = new US0002QAConcortPage();
        SoftAssert softAssert = new SoftAssert();
        //1- Bir yönetici olarak otelin anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        //2- Sağ üstte yer alan "log in" butonuna tıklayın.
        US2QaPage.firstlogIn.click();
        //3- Açılan pencerede yer alan username textbox'ına geçerli "username"i girin.
        US2QaPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        //4- Açılan pencerede yer alan password textbox'ına geçerli "password"u girin.
        US2QaPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        //5- Sayfada login butonunun görülebilir ve tıklanabilir olduğunu test edin
        Assert.assertTrue(US2QaPage.secondLogIn.isDisplayed(),"Login butonu görüntülenemiyor");
        Assert.assertTrue(US2QaPage.secondLogIn.isEnabled(),"Login butonuna tıklanamıyor");
        //6- Login butonuna tıklayın
        US2QaPage.secondLogIn.click();
        //7- Açılan sayfada "LISTOFUSERS" yazısının görülebilir olduğunu test edin
        Assert.assertTrue(US2QaPage.listOfUsers.isDisplayed(),"LİSTOFUSERS yazısı görülebilir değil");
        //8- Açılan sayfanın URL'inin "https://qa-environment.concorthotel.com/Admin/UserAdmin" olduğunu doğrulayın
        String expectedURL = ConfigReader.getProperty("CHQAManagerPageURL");
        String actualURL = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualURL,expectedURL,"URL beklenen ile aynı değil");

        softAssert.assertAll();

        Driver.closeDriver();



    }
}
