package tests.selcuk;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_009QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_009_TC_002 extends TestBaseRapor {


    @Test
    public void editHotelroomreservation(){

        extentTest=extentReports.createTest("Concort Hotel Test","List of reservations sayfasındaki reservation'un detail kısmına tıklandığında Edit Hotelroomreservatıon sayfasına gidebilmeliyim");

        extentTest.pass("CONCORT HOTEL sayfasina gidildi");

        // 1-Kullanıcı Concort HOTELS sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        //  US_009QAConcortPage sayfasindan Obje olusturmaliyiz
        US_009QAConcortPage us_009QAConcortPage=new US_009QAConcortPage();

        //  2-Kullanıcı sağ üstteki "Log in" butonuna tıklar
        us_009QAConcortPage.firstlogIn.click();

        extentTest.pass("Kullanici username Text box a tiklar");
        // 3-Kullanıcı açılan menude username Text Box'a tıklar
        us_009QAConcortPage.userName.click();

        //  4-Kullanıcı açılan menude username Text Box'a username yazar
        us_009QAConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        //  5-Kullanıcı Password Textbox'a password yazar
        us_009QAConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));

        extentTest.pass("kullanici log in butonuna tiklar");
        //  6-Kullanıcı "Log in" butonuna tıklar
        us_009QAConcortPage.logInButton.click();

        //  7-Hotel management butonuna tiklayin
        us_009QAConcortPage.hotelManagementLinki.click();

        //  8-Room Reservations butonuna tiklayiniz
        us_009QAConcortPage.roomReservation.click();

        // 9-"Details" butonuna tiklayiniz
        us_009QAConcortPage.detailsYazisi.click();

        extentTest.pass("Edit Hotelroomreservation yazinin gorulmesini kontrol eder");
        // 10-"Edit Hotelroomreservation" yazisinin goruldugunu
        Assert.assertTrue(us_009QAConcortPage.editHotelroomReservationYazisi.isDisplayed(),"Edit Hotelroomreservation yazisi gorulmedi");


        //  11 -Sayfayi kapatiniz
           // Driver.closeDriver();
    }
}
