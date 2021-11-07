package tests.melike;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US0002QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_0002_TC_0002 extends TestBaseRapor {

    @Test
    public void test2 () {

        US0002QAConcortPage US2QaPage = new US0002QAConcortPage();
        SoftAssert softAssert = new SoftAssert();
        //1- Bir yönetici olarak otelin anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        //2- Sağ üstteki "log in" butonuna tıklayın.
        US2QaPage.firstlogIn.click();
        //3- Login sayfasına gidin.
        String expectedURLLOginPage = ConfigReader.getProperty("CHQALoginPageURL");
        String actualURLLoginPage = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualURLLoginPage,expectedURLLOginPage,"Sayfa URL'i beklenen URL ile aynı değil");
        //4- Sayfada yer alan username textboxına tıklayın.
        US2QaPage.userName.click();
        Assert.assertTrue(US2QaPage.userName.isEnabled(),"username textboxı tıklanabilir değil");


        //5- username textbox'ının yazılabilir olduğunu test edin
        US2QaPage.userName.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        System.out.println("username textbox yazılabilir durumda");
        //6- Sayfada yer alan "password" textbox'ına tıklayın.
        US2QaPage.password.click();
        //7- "password" textbox'ının yazılabilir olduğunu test edin.
        US2QaPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        System.out.println("password textbox yazılabilir durumda");
        softAssert.assertAll();
        extentTest=extentReports.createTest("Login sayfasi textbox'ının yazılabilir olduğunu testi");
        Driver.closeDriver();
    }
}
