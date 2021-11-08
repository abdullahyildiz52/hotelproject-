package tests.lufiye;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0007_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_007_TC02 extends TestBaseRapor {
    US_0007_QAConcortPage qaConcortPage7=new US_0007_QAConcortPage();
    @Test
    public void Test(){


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
        //7- LIST OF HOTELROOMS sayfasında  "actions"sütünundaki details butonlarının tıklanabilir olmalı
        //8-Yönetici details butonuna tıklar

        qaConcortPage7.detailsButton.click();
        //9-Yönetici details butonuna tıkladığında  "Edit HotelRooom" sayfasını görmeli

        Assert.assertTrue(qaConcortPage7.editHotelRoom.isDisplayed());
        extentTest=extentReports.createTest("Yöneticinin Edit HotelRooom sayfasında olduğu testi");
}
}
