package tests.selcuk;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_009QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_009_TC_003 extends TestBaseRapor {


    @Test
    public void positiveTest(){

        extentTest=extentReports.createTest("Concort Hotel Test","Edit Hotelroomreservatıon sayfasındaki reservation bilgilerinin güncellenip kaydedilmeli");
        extentTest.pass("CONCORT HOTEL sayfasina gidildi");
    // 1-Kullanıcı Concort HOTELS sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

    //  US_009QAConcortPage sayfasindan Obje olusturmaliyiz
    US_009QAConcortPage us_009QAConcortPage=new US_009QAConcortPage();

    //  2-Kullanıcı sağ üstteki "Log in" butonuna tıklar
        us_009QAConcortPage.firstlogIn.click();

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

       // FAKER YONTEMI icin

        extentTest.info("faker yontemi ile email adres olusturduk ve bunu String bir deger atadik");
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();

        extentTest.info("faker yontemi ile ilgili alanlar doldurulur");
    // 11-"Price" kismina bir sayi giriniz(Faker Yontemi)
        us_009QAConcortPage.price.sendKeys(String.valueOf(faker.number().numberBetween(100,999)));

        // 12-"Adult Amount" kismina bir sayi girin
        us_009QAConcortPage.adultAmount.sendKeys(String.valueOf(faker.number().numberBetween(1,6)));

        //  13-"Childeren Amount" kismina sayi giriniz

        us_009QAConcortPage.childrenAmount.sendKeys(String.valueOf(faker.number().numberBetween(1,11)));

        //  14-"Contact Name Surname" kismina bir isim giriniz

        us_009QAConcortPage.contactNameSurname.sendKeys(faker.name().lastName());

        //  15-"Contact Phone" kismina gecerli bir numara giriniz
        us_009QAConcortPage.contactPhone.sendKeys(faker.phoneNumber().phoneNumber());

        // 16-"Contact Email" kismina gecerli bir Email adresi giriniz
        us_009QAConcortPage.contactEmail.sendKeys(email);

        //  17-"Notes" kisimina bir Not giriniz
        us_009QAConcortPage.notes.clear();
        us_009QAConcortPage.notes.sendKeys("Otel degisiklikleri basari ile gerceklesmistir");

        extentTest.pass("save butonuna tiklar ve alert yazisi gorulmeli");
        // 18"Save" butonuna tiklar ve alert yazisi gorulmeli
        us_009QAConcortPage.btnGreen.click();

        //   -Sayfayi kapatiniz
            Driver.closeDriver();
    }
}
