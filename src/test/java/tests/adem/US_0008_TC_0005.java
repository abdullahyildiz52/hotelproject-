package tests.adem;

import com.github.javafaker.Faker;
import jdk.jfr.Threshold;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_0008_QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0008_TC_0005 {
    @Test
    public void test() throws InterruptedException {
        US_0008_QAConcortPage qaConcortPage = new US_0008_QAConcortPage();
        //1- Hotel sayfsına gidiniz.
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        //2- Sağ üstteki "log in" butonuna tıklayınız.
        qaConcortPage.firstlogIn.click();

        //3- Açılan pencere "username"i giriniz.
        qaConcortPage.userName.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        //4- "password"u giriniz ve giriş yapınız.
        qaConcortPage.password.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.logInButton.click();
        //5- Açılan "ListOfUsers" sayfasının yanındaki "Hotel Management"a tıklayınız.
        qaConcortPage.hotelManagementLinki.click();

        //6- "Room reservations"e tıklayınız.
        qaConcortPage.roomReservationLink.click();

        //7- "Add Room Reservation" tıklayınız.
        //8-"Create Hotelroomreservatıon" sayfasına gidlir.
        qaConcortPage.addRoomReservationLink.click();

        //9-"IDUser" seçilir ve "Select User" dan "manager" tıklanır.
        Actions actions = new Actions(Driver.getDriver());


        Select select = new Select(qaConcortPage.IDUserDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAddRoomIDUser"));
        actions.sendKeys(Keys.TAB);

        //10-"IDUser" seçilir ve "Select HotelRoom" dan "Star Hotel" seçilir.
        select = new Select(qaConcortPage.IDhotelRoomDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("CHQAddRoomIDHotelRoom"));

        //11-"Price" kutusuna tıklayınız.

        actions.
                sendKeys(ConfigReader.getProperty("CHQAddRoomPrice")).
                perform();


        //12-"DateStart" kutusuna tıklayınız.
        actions.sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAddRoomDateStart")).
                perform();


        //13- "DateEnd" kutusuna tıklayınız
        actions.sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAddRoomDateEnd")).
                perform();


        Faker faker = new Faker();

        String contactNameSurname = faker.name().name();
        actions.sendKeys(Keys.TAB).

                //14-"AdultAmount" kutusuna tıkalyınız

                        sendKeys(Keys.TAB).
                sendKeys(String.valueOf(faker.number().numberBetween(1, 2))).
                //15-"ChildrenAmount" kutusuna tıklayınız

                        sendKeys(Keys.TAB).
                sendKeys(String.valueOf(faker.number().numberBetween(0, 5))).
                sendKeys(Keys.PAGE_DOWN).

                //16-"ContactNameSurname" kutusuna tıkalyınız
                        sendKeys(Keys.TAB).
                sendKeys(contactNameSurname).

                //17-"ContactPhone" tıkalyınız
                        sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).

                //18-"Contact Email" kısmına tıkalyınız
                        sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).

                //19-"Notes" tıkalyınız
                        sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("CHQAddRoomNotes")).

                //20-"Approved" sbace bar ile tıkalyınız
                        sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE).

                //21-"Is paid" kısmına space bar ile tıkalyınız
                        sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE).
                //2-"SAVE" butonuna tıklayınız
                        sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE).perform();


        //3-Başarılı alert görülmesini test ediniz
        // Assert.assertTrue(qaConcortPage.basariliAddRoomYazisi.isDisplayed());

        qaConcortPage.addRoomOkButon.click();

        actions.sendKeys(Keys.PAGE_UP);
        actions.sendKeys(Keys.PAGE_UP);
        actions.sendKeys(Keys.PAGE_UP);
        actions.sendKeys(Keys.PAGE_UP);
        actions.sendKeys(Keys.PAGE_UP);
        actions.sendKeys(Keys.PAGE_UP);

        actions.sendKeys(Keys.PAGE_UP);
        qaConcortPage.backRoomReservation.click();

        qaConcortPage.contactName.click();


        System.out.println(contactNameSurname);
        Thread.sleep(2000);
        actions.sendKeys(contactNameSurname).perform();
        Thread.sleep(2000);
        qaConcortPage.searchButon.click();

        Thread.sleep(2000);
        System.out.println(qaConcortPage.baslik2satir9sutun.getText());
        Assert.assertEquals(contactNameSurname, qaConcortPage.baslik2satir9sutun.getText());

        Thread.sleep(2000);
        Driver.closeDriver();

    }
}
