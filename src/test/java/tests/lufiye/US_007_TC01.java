package tests.lufiye;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import pages.QAConcortPage7;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_007_TC01 extends TestBaseRapor {
    QAConcortPage7 qaConcortPage7=new QAConcortPage7();
@Test
        public void positiveLoginTest() throws InterruptedException {
    //1-Yönetici ConcortHotel anasayfasına gider
    //2-Yönetici sayfada sağ üstte bulunan "Log in" butonuna tıklar
    //3-Yönetici geçerli 'Username' le giriş yapar
    //4-Yönetici gecerli 'Password' le giriş yapar ve log in butonuna basar
    Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
    qaConcortPage7.firstlogIn.click();
    qaConcortPage7.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
    qaConcortPage7.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
    qaConcortPage7.logInButton.click();
    //5-Yönetici açılan sayfada sol üstte bulunan Hotel Managemet tıklar
    qaConcortPage7.hotelManagementLinki.click();
    //6-Yönetici Hotel Rooms'a tıklar
   qaConcortPage7.hotelRoomsLinki.click();
   Thread.sleep(2000);

    //7-Yöneticinin"LIST OF HOTELROOMS" sayfasında olduğunu test edin
   Assert.assertTrue(qaConcortPage7.listOfHotelroomlinki.isDisplayed());
    extentTest=extentReports.createTest("Yöneticinin\"LIST OF HOTELROOMS\" sayfasında olduğu testi");
    Driver.closeDriver();
}
}