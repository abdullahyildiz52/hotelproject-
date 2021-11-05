package tests.lufiye;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage7;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import javax.swing.*;

public class US_007_TC05 extends TestBaseRapor {
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
   Thread.sleep(1000);

//7- LIST OF HOTELROOMS sayfasında  "actions"sütünundaki details butonlarının tıklanabilir olmalı
//8-Yönetici details butonuna tıklar
        qaConcortPage7.detailsButton.click();
//9-Yönetici details butonuna tıkladığında  "Edit HotelRooom" sayfasını görmeli
        Assert.assertTrue(qaConcortPage7.editHotelRoom.isDisplayed());
//10-"Edit HotelRooom"room bilgileri silinebilmeli

        qaConcortPage7.delete.click();
        Thread.sleep(2000);

        Thread.sleep(2000);
        qaConcortPage7.onayButonu.click();
        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage7.deleteAlertMesaj.isDisplayed());
}
}
