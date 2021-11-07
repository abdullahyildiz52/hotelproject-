package tests.lufiye;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage7;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_007_TC04 extends TestBaseRapor {
    QAConcortPage7 qaConcortPage7 = new QAConcortPage7();

    @Test
    public void pozitifTest() throws InterruptedException {
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
        //9-Yönetici details butonuna tıkladığında  "Edit HotelRooom" sayfası açılmalı
        Assert.assertTrue(qaConcortPage7.editHotelRoom.isDisplayed());
    //10-Sayfada oda rezervasyonunu yapılmış olmalı

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);
        qaConcortPage7.save.click();
        Thread.sleep(2000);
       qaConcortPage7.save.getText().equals("HotelRoom was updated successfully");

       qaConcortPage7.okButon.click();

       // 11-Yönetici Edit HotelRoom sayfasında en altta bulunan "Delete" tusuna bastığında ALERT mesajını görmeli
        actions.sendKeys(Keys.PAGE_DOWN).perform();

       Thread.sleep(2000);
        qaConcortPage7.deleteButonu.click();
        Thread.sleep(2000);
        //Assert.assertTrue(qaConcortPage7.deleteAlertMesaj.isDisplayed());
       qaConcortPage7.deleteButonu.getText().equals("Would you like to continue?");
        //Thread.sleep(2000);
        qaConcortPage7.onayButonu.click();

        extentTest=extentReports.createTest("Edit HotelRooom sayfasında DELETE testi");
    }
}