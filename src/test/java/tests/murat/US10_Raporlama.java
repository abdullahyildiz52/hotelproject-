package tests.murat;


import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0010_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US10_Raporlama extends TestBaseRapor {

    @Test
    public void test1() throws InterruptedException {

        extentTest=extentReports.createTest("Yeni kullanıcı oluşturma testi","sonuc basarili olmali");

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        extentTest.info("concorthotel sayfasina gidildi");

        US_0010_QAConcortPage us10_qaConcortPage=new US_0010_QAConcortPage();

        us10_qaConcortPage.ilkLoginLinki.click();

        us10_qaConcortPage.createNewAccountButonu.click();


        //new account butonuna tıklandı

        extentTest.info("new account butonuna tıklandı");


        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        actions.
                click(us10_qaConcortPage.newusernameKutusu).
                sendKeys(faker.name().username()).perform();

        us10_qaConcortPage.newpasswordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidNewPassword"));
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.internet().emailAddress()).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewFullName")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewPhoneNo")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewSSN")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewDrivingLisance")).perform();

        Select select=new Select(us10_qaConcortPage.addCountryDropdown);

        select.selectByVisibleText(ConfigReader.getProperty("CHQAValidNewCountryOption"));

        Select select1=new Select(us10_qaConcortPage.addStateDropdown);

        select1.selectByVisibleText(ConfigReader.getProperty("CHQAValidNewStateOption"));

        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(ConfigReader.getProperty("CHQAValidNewAddres")).perform();

        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(ConfigReader.getProperty("CHQAValidNewWorkSector")).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewBirthDay")).perform();

        actions.click(us10_qaConcortPage.addHotelSave).perform();

        extentTest.info("kayıt oluşturuldu");
        Thread.sleep(2000);
        System.out.println(us10_qaConcortPage.addHotelSuccesfullYazisi.getText());

        Thread.sleep(2000);
        Assert.assertTrue(us10_qaConcortPage.addHotelSuccesfullYazisi.isDisplayed());
        Thread.sleep(2000);
        extentTest.pass("basarılı yazısı görüldü");
    }


    @Test
    public void test2() throws InterruptedException {

        extentTest=extentReports.createTest("Otel odası seçme testi","sonuc basarili olmali");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        extentTest.info("concorthotel sayfasina gidildi");

        US_0010_QAConcortPage us10_qaConcortPage =new US_0010_QAConcortPage();

        us10_qaConcortPage.ilkLoginLinki.click();

        us10_qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidNewUsername"));

        us10_qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidNewPassword"));

        us10_qaConcortPage.logInButton.click();

        extentTest.info("login sayfasinda username ve password ile girildi");
        us10_qaConcortPage.addMusteriSaveButonu.click();

        Thread.sleep(2000);

        us10_qaConcortPage.addMusteriKabulOk.click();

        Actions actions=new Actions(Driver.getDriver());

        Thread.sleep(3000);

        actions.sendKeys(Keys.PAGE_UP).perform();
        //    sendKeys(Keys.PAGE_UP).
        Thread.sleep(3000);

        us10_qaConcortPage.addOdaTikla.click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        us10_qaConcortPage.addOtelSecimi.click();

        extentTest.info("otel odası seçildi");

        //  Thread.sleep(5000);

        extentTest.pass("basarılı oldu");
    }


    @Test
    public void test3() throws InterruptedException {

        extentTest=extentReports.createTest("oda rezervasyonu yapıp detayları görme testi","sonuç basarılı olmalı");
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        US_0010_QAConcortPage us10_qaConcortPage=new US_0010_QAConcortPage();

        us10_qaConcortPage.ilkLoginLinki.click();

        us10_qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidNewUsername"));

        us10_qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidNewPassword"));
        us10_qaConcortPage.logInButton.click();

        us10_qaConcortPage.addMusteriSaveButonu.click();

        Thread.sleep(2000);

        us10_qaConcortPage.addMusteriKabulOk.click();

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        Thread.sleep(3000);

        actions.sendKeys(Keys.PAGE_UP).perform();

        Thread.sleep(3000);

        us10_qaConcortPage.addOdaTikla.click();

        Thread.sleep(1000);
        us10_qaConcortPage.odaGirisTarihi.clear();
        us10_qaConcortPage.odaGirisTarihi.sendKeys("11/7/2021");

        actions.sendKeys(Keys.TAB).perform();

        us10_qaConcortPage.otelCikisTarihi.sendKeys("11/14/2021");

        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB).perform();

        Select select=new Select(us10_qaConcortPage.addRoomTypeDropdown);
        Thread.sleep(2000);

        select.selectByVisibleText(ConfigReader.getProperty("CHQARoomType"));

        Select select1=new Select(us10_qaConcortPage.addAdultDropdown);
        Thread.sleep(2000);

        select1.selectByVisibleText(ConfigReader.getProperty("CHQASelectAdult"));

        Select select2=new Select(us10_qaConcortPage.addChildDropdown);

        select2.selectByVisibleText(ConfigReader.getProperty("CHQASelectChild"));

        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        actions.click(us10_qaConcortPage.odasearchButonu).perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        us10_qaConcortPage.addOtelSecimi.click();

        us10_qaConcortPage.odaGirisTarihi.clear();
        us10_qaConcortPage.odaGirisTarihi.sendKeys("11/7/2021");
        actions.sendKeys(Keys.TAB).perform();

        us10_qaConcortPage.otelCikisTarihi.sendKeys("11/14/2021");
        actions.sendKeys(Keys.TAB).perform();

        Select select3=new Select(us10_qaConcortPage.addAdultDropdown);

        select3.selectByVisibleText(ConfigReader.getProperty("CHQASelectAdult"));
        actions.sendKeys(Keys.TAB).perform();

        Select select4=new Select(us10_qaConcortPage.addChildDropdown);

        select4.selectByVisibleText(ConfigReader.getProperty("CHQASelectChild"));

        actions.sendKeys(Keys.TAB).perform();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAValidNewFullName")).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).perform();
        us10_qaConcortPage.emailAdres.clear();
        us10_qaConcortPage.emailAdres.sendKeys("Sancak414j@hotmail.com");

        actions.sendKeys(Keys.TAB).perform();

        faker.phoneNumber();

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQACreditCardName")).

                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQACreditCardNo")).perform();
        actions.sendKeys(Keys.TAB).perform();

        Select select5=new Select(us10_qaConcortPage.addOtelGirisDropdown);

        select5.selectByVisibleText(ConfigReader.getProperty("CHQACreditCardSonYil"));
        actions.sendKeys(Keys.TAB).perform();

        Select select6=new Select(us10_qaConcortPage.addOtelCikisDropdown);

        select6.selectByVisibleText(ConfigReader.getProperty("CHQACreditCardSonAy"));

        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQACreditCardCVV")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("CHQAKayitMessage")).perform();

        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        us10_qaConcortPage.bookThisRoomButonu.click();

        Thread.sleep(3000);

        Assert.assertTrue(us10_qaConcortPage.basariliReservationYazisi.isDisplayed());

        Thread.sleep(5000);

        actions.click(us10_qaConcortPage.yourReservationHere).perform();

        Thread.sleep(2000);

        Assert.assertTrue(us10_qaConcortPage.reservationDetails.isDisplayed());

        Thread.sleep(2000);

        us10_qaConcortPage.userMenuReservations.click();
        Assert.assertTrue(us10_qaConcortPage.reservationsYaziElementi.isDisplayed());

        actions.sendKeys(Keys.PAGE_DOWN). perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN). perform();
        Thread.sleep(2000);

        us10_qaConcortPage.detailsOdaNumber.click();

        Assert.assertTrue(us10_qaConcortPage.reservationDetails.isDisplayed());

        extentTest.pass("Otel oda rezervasyonu yapıldı,oda detayları görüntülendi");
    }

}



